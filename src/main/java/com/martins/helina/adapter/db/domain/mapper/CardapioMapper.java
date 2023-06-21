package com.martins.helina.adapter.db.domain.mapper;

import java.util.stream.Collectors;

import com.martins.helina.adapter.db.domain.Cardapio;
import com.martins.helina.entrypoint.dto.CardapioDTO;

public class CardapioMapper {

	public static Cardapio fromDTOToEntity(CardapioDTO cardapioDTO) {
		return Cardapio.builder()
				.idCardapio(cardapioDTO.getIdCardapio())
				.idEstabelecimento(cardapioDTO.getIdEstabelecimento())
				.itensCardapio(cardapioDTO.getItensCardapio().stream()
						.map(ItemCardapioMapper::fromDTOToEntity)
						.collect(Collectors.toList()))
				.build();
	}

	public static CardapioDTO fromEntityToDTO(Cardapio cardapio) {
		return CardapioDTO.builder()
				.idCardapio(cardapio.getIdCardapio())
				.idEstabelecimento(cardapio.getIdEstabelecimento())
				.itensCardapio(cardapio.getItensCardapio().stream()
						.map(ItemCardapioMapper::fromEntityToDTO)
						.collect(Collectors.toList()))
				.build();
	}

}
