package com.martins.helina.adapter.db.domain.mapper;

import com.martins.helina.adapter.db.domain.ItemCardapio;
import com.martins.helina.entrypoint.dto.ItemCardapioDTO;

public class ItemCardapioMapper {

	public static ItemCardapio fromDTOToEntity(ItemCardapioDTO itemCardapioDTO) {
		return ItemCardapio.builder()
				.idCardapio(itemCardapioDTO.getIdCardapio())
				.idItem(itemCardapioDTO.getIdItem())
				.nmItem(itemCardapioDTO.getNmItem())
				.preco(itemCardapioDTO.getPreco())
				.build();
	}

	public static ItemCardapioDTO fromEntityToDTO(ItemCardapio itemCardapio) {
		return ItemCardapioDTO.builder()
				.idCardapio(itemCardapio.getIdCardapio())
				.idItem(itemCardapio.getIdItem())
				.nmItem(itemCardapio.getNmItem())
				.preco(itemCardapio.getPreco())
				.build();
	}

}
