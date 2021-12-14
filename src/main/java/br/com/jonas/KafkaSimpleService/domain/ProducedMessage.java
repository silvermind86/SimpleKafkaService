package br.com.jonas.KafkaSimpleService.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class ProducedMessage {

    private String name;
    private int age;
    private List<String> metadata;

    public ProducedMessage(OriginalMessage received) {
        this.name = received.getName();
        this.age = 2021 - received.getYearOfBirth();
        this.metadata = new ArrayList<>();
        this.metadata.addAll(received.getMetadata());
        this.metadata.add(String.valueOf(received.getYearOfBirth()));
    }
}
