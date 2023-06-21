package com.martins.helina.entrypoint.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class EstabelecimentoDTO {
	
	private Long idEstabelecimento;
	
	private Long cnpj;
	
	private String razaoSocial;
	
	private String nomeFantasia;
	
	private String tipoReserva;
	
	private CardapioDTO cardapio;
	
	private List<CronogramaDTO> diasAbertura;
	
	private EnderecoDTO endereco;
	
	private Integer totalVagas;

	
}
