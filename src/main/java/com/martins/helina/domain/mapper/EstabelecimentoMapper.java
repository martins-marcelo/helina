package com.martins.helina.domain.mapper;

import java.util.stream.Collectors;

import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.domain.Estabelecimento;

public class EstabelecimentoMapper {
	
	private EstabelecimentoMapper() {
		throw new IllegalStateException("Mapper class");
	}

	public static Estabelecimento fromDTOToEntity(EstabelecimentoDTO estabelecimentoDTO) {
		return Estabelecimento.builder()
				.cnpj(estabelecimentoDTO.getCnpj())
				.id(estabelecimentoDTO.getId())
				.nomeFantasia(estabelecimentoDTO.getNomeFantasia())
				.razaoSocial(estabelecimentoDTO.getRazaoSocial())
				.tipoReserva(estabelecimentoDTO.getTipoReserva())
				.totalVagas(estabelecimentoDTO.getTotalVagas())
				.reservaAutomatica(estabelecimentoDTO.getReservaAutomatica())
				.cardapio(CardapioMapper.fromDTOToEntity(estabelecimentoDTO.getCardapio()))
				.diasAbertura(estabelecimentoDTO.getDiasAbertura().stream()
						.map(CronogramaMapper::fromDTOToEntity)
						.collect(Collectors.toList()))
				.endereco(EnderecoMapper.fromDTOToEntity(estabelecimentoDTO.getEndereco()))
				.reservas(estabelecimentoDTO.getReservas().stream().map(ReservaMapper::fromDTOToEntity).collect(Collectors.toList()))
				.build();
	}

	public static EstabelecimentoDTO fromEntityToDTO(Estabelecimento estabelecimento) {
		return EstabelecimentoDTO.builder()
				.cnpj(estabelecimento.getCnpj())
				.id(estabelecimento.getId())
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
