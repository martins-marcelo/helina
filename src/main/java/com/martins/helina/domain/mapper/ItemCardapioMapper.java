package com.martins.helina.domain.mapper;

import com.martins.helina.controller.dto.ItemCardapioDTO;
import com.martins.helina.domain.ItemCardapio;

public class ItemCardapioMapper {

	public static ItemCardapio fromDTOToEntity(ItemCardapioDTO itemCardapioDTO) {
		return ItemCardapio.builder()
				.nome(itemCardapioDTO.getNome())
				.preco(itemCardapioDTO.getPreco())
				.descricao(itemCardapioDTO.getDescricao())
				.build();
	}

	public static ItemCardapioDTO fromEntityToDTO(ItemCardapio itemCardapio) {
		return ItemCardapioDTO.builder()
				.nome(itemCardapio.getNome())
				.preco(itemCardapio.getPreco())
				.descricao(itemCardapio.getDescricao())
				.build();
	}

}
