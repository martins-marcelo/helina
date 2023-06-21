package com.martins.helina.adapter.db.domain.mapper;

import com.martins.helina.adapter.db.domain.Endereco;
import com.martins.helina.entrypoint.dto.EnderecoDTO;

public class EnderecoMapper {
	
	public static Endereco fromDTOToEntity(EnderecoDTO dto) {
		return Endereco.builder()
				.cep(dto.getCep())
				.cidade(dto.getCidade())
				.complemento(dto.getComplemento())
				.estado(dto.getEstado())
				.idEndereco(dto.getIdEndereco())
				.logradouro(dto.getLogradouro())
				.numero(dto.getNumero())
				.build();
	}
	
	public static EnderecoDTO fromEntityToDTO(Endereco endereco) {
		return EnderecoDTO.builder()
				.cep(endereco.getCep())
				.cidade(endereco.getCidade())
				.complemento(endereco.getComplemento())
				.estado(endereco.getEstado())
				.idEndereco(endereco.getIdEndereco())
				.logradouro(endereco.getLogradouro())
				.numero(endereco.getNumero())
				.build();
	}

}
