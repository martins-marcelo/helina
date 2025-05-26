package com.martins.helina.domain.mapper;

import com.martins.helina.controller.dto.EnderecoDTO;
import com.martins.helina.domain.Endereco;

public class EnderecoMapper {
	
	public static Endereco fromDTOToEntity(EnderecoDTO dto) {
		return Endereco.builder()
				.cep(dto.getCep())
				.cidade(dto.getCidade())
				.complemento(dto.getComplemento())
				.estado(dto.getEstado())
				.rua(dto.getRua())
				.bairro(dto.getBairro())
				.numero(dto.getNumero())
				.build();
	}
	
	public static EnderecoDTO fromEntityToDTO(Endereco endereco) {
		return EnderecoDTO.builder()
				.cep(endereco.getCep())
				.cidade(endereco.getCidade())
				.complemento(endereco.getComplemento())
				.estado(endereco.getEstado())
				.rua(endereco.getRua())
				.bairro(endereco.getBairro())
				.numero(endereco.getNumero())
				.build();
	}

}
