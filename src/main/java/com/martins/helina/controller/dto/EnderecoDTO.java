package com.martins.helina.controller.dto;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class EnderecoDTO {
	
	private Long idEndereco;
	
	private String logradouro;
	
	private String numero;
	
	private String complemento;
	
	private String cidade;
	
	private String estado;
	
	private String cep;
}
