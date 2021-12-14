package br.com.jonas.KafkaSimpleService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableKafka
@EnableAsync
public class KafkaSimpleServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSimpleServiceApplication.class, args);
	}

}
