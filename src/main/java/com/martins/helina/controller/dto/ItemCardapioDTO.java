package com.martins.helina.controller.dto;
import lombok.Builder;
import lombok.Data;

@Builder @Data
public class ItemCardapioDTO {
    private String nome;
    private String descricao;
    private Double preco;

}
