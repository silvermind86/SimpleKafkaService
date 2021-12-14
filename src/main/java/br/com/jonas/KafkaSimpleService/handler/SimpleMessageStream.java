package br.com.jonas.KafkaSimpleService.handler;

import br.com.jonas.KafkaSimpleService.domain.OriginalMessage;
import br.com.jonas.KafkaSimpleService.domain.ProducedMessage;
import br.com.jonas.KafkaSimpleService.service.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SimpleMessageStream {

    @Autowired
    private MessageService messageService;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.topic.treated-message-box}")
    String destinyTopic;

    @KafkaListener(topics = "${kafka.topic.message-box}")
    @SendTo
    public void listen(String json) throws InterruptedException, JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        OriginalMessage message = mapper.readValue(json, OriginalMessage.class);

        ProducedMessage response = messageService.createMessage(message);

        String jsonString = mapper.writeValueAsString(response);
        kafkaTemplate.send(new ProducerRecord<String, String>(destinyTopic, jsonString));

        log.info(String.format("Message: %s, send successfully.", jsonString));
    }

}
