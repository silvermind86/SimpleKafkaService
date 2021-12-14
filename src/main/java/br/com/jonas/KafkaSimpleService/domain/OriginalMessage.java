package br.com.jonas.KafkaSimpleService.domain;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class OriginalMessage {

    private String name;
    private int yearOfBirth;
    private List<String> metadata;

}
