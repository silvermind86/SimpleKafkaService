package br.com.jonas.KafkaSimpleService.service;

import br.com.jonas.KafkaSimpleService.domain.OriginalMessage;
import br.com.jonas.KafkaSimpleService.domain.ProducedMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public ProducedMessage createMessage(OriginalMessage received){
        return new ProducedMessage(received);
    }

}
