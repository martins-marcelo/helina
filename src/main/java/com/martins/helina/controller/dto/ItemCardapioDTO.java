package com.martins.helina.controller.dto;

import java.math.BigDecimal;

import com.martins.helina.adapter.db.domain.Cardapio;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class ItemCardapioDTO {
	
	private Long idItem;
	
	private Cardapio idCardapio;
	
	private String nmItem;
	
	private BigDecimal preco;

}
