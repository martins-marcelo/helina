package com.martins.helina.domain;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDbBean
public class ItemCardapio {
    private String nome;
    private String descricao;
    private Double preco;
    private String imagemUrl;
}
