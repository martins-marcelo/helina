package com.martins.helina.domain;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDbBean
public class Cronograma {
    private String diaSemana;
    private String horaAbertura;
    private String horaFechamento;
}
