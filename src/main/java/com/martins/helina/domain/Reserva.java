package com.martins.helina.domain;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSecondaryPartitionKey;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDbBean
public class Reserva {
    private String idReserva;
    private String idUsuario;
    private String idEstabelecimento;
    private String nomeUsuario;
    private String dataHoraReserva;
    private Integer quantidadePessoas;
    private String status;

    @DynamoDbPartitionKey
    public String getIdReserva() {
        return idReserva;
    }

    @DynamoDbSecondaryPartitionKey(indexNames = "gsi_usuario")
    public String getIdUsuario() {
        return idUsuario;
    }

    @DynamoDbSecondaryPartitionKey(indexNames = "gsi_estabelecimento")
    public String getIdEstabelecimento() {
        return idEstabelecimento;
    }
}
