package com.martins.helina.domain;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDbBean
public class Estabelecimento {

    private String id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String tipoReserva;
    private Integer totalVagas;
    private Boolean reservaAutomatica;

    private Endereco endereco;
    private Cardapio cardapio;
    private List<Cronograma> diasAbertura;
    private List<Reserva> reservas;

    @DynamoDbPartitionKey
    @DynamoDbAttribute("id")
    public String getId() {
        return id;
    }

    @DynamoDbAttribute("endereco")
    public Endereco getEndereco() {
        return endereco;
    }

    @DynamoDbAttribute("cardapio")
    public Cardapio getCardapio() {
        return cardapio;
    }

    @DynamoDbAttribute("diasAbertura")
    public List<Cronograma> getDiasAbertura() {
        return diasAbertura;
    }

    @DynamoDbAttribute("reservas")
    public List<Reserva> getReservas() {
        return reservas;
    }
}
