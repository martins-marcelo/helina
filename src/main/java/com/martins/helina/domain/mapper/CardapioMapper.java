package com.martins.helina.domain.mapper;

import java.util.stream.Collectors;

import com.martins.helina.controller.dto.CardapioDTO;
import com.martins.helina.domain.Cardapio;

public class CardapioMapper {

	public static Cardapio fromDTOToEntity(CardapioDTO cardapioDTO) {
		return Cardapio.builder()
				.itens(cardapioDTO.getItens().stream()
						.map(ItemCardapioMapper::fromDTOToEntity)
						.collect(Collectors.toList()))
				.build();
	}

	public static CardapioDTO fromEntityToDTO(Cardapio cardapio) {
		return CardapioDTO.builder()
				.itens(cardapio.getItens().stream()
						.map(ItemCardapioMapper::fromEntityToDTO)
						.collect(Collectors.toList()))
				.build();
	}

}
