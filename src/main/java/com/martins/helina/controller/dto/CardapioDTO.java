package com.martins.helina.controller.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class CardapioDTO {
	
	private Long idCardapio;
	
	private Long idEstabelecimento;
	
	private List<ItemCardapioDTO> itensCardapio;

}
