package com.martins.helina.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class EnderecoDTO {
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
	private String complemento;
}
