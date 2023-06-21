package com.martins.helina.adapter.db.domain.mapper;

import java.util.stream.Collectors;

import com.martins.helina.adapter.db.domain.Estabelecimento;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;

public class EstabelecimentoMapper {

	public static Estabelecimento fromDTOToEntity(EstabelecimentoDTO estabelecimentoDTO) {
		return Estabelecimento.builder()
				.cnpj(estabelecimentoDTO.getCnpj())
				.idEstabelecimento(estabelecimentoDTO.getIdEstabelecimento())
				.nomeFantasia(estabelecimentoDTO.getNomeFantasia())
				.razaoSocial(estabelecimentoDTO.getRazaoSocial())
				.tipoReserva(estabelecimentoDTO.getTipoReserva())
				.totalVagas(estabelecimentoDTO.getTotalVagas())
				.cardapio(CardapioMapper.fromDTOToEntity(estabelecimentoDTO.getCardapio()))
				.diasAbertura(estabelecimentoDTO.getDiasAbertura().stream()
						.map(CronogramaMapper::fromDTOToEntity)
						.collect(Collectors.toList()))
				.endereco(EnderecoMapper.fromDTOToEntity(estabelecimentoDTO.getEndereco()))
				.build();
	}

	public static EstabelecimentoDTO fromEntityToDTO(Estabelecimento estabelecimento) {
		return EstabelecimentoDTO.builder()
				.cnpj(estabelecimento.getCnpj())
				.idEstabelecimento(estabelecimento.getIdEstabelecimento())
				.nomeFantasia(estabelecimento.getNomeFantasia())
				.razaoSocial(estabelecimento.getRazaoSocial())
				.tipoReserva(estabelecimento.getTipoReserva())
				.totalVagas(estabelecimento.getTotalVagas())
				.cardapio(CardapioMapper.fromEntityToDTO(estabelecimento.getCardapio()))
				.diasAbertura(estabelecimento.getDiasAbertura().stream()
						.map(CronogramaMapper::fromEntityToDTO)
						.collect(Collectors.toList()))
				.endereco(EnderecoMapper.fromEntityToDTO(estabelecimento.getEndereco()))
				.build();
	}

}
