package com.martins.helina.controller.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class EstabelecimentoDTO {
	
    private String id;
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private String tipoReserva;
    private Integer totalVagas;
    private Boolean reservaAutomatica;
	
	private CardapioDTO cardapio;	
	private List<CronogramaDTO> diasAbertura;	
	private EnderecoDTO endereco;
    private List<ReservaDTO> reservas;
		
}
