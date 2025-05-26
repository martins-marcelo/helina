package com.martins.helina.domain.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.martins.helina.controller.dto.CronogramaDTO;
import com.martins.helina.domain.Cronograma;

public class CronogramaMapper {

	public static List<Cronograma> fromListDTO(List<CronogramaDTO> cronogramasDTO){
		return cronogramasDTO.stream().map(CronogramaMapper::fromDTOToEntity).collect(Collectors.toList());
	}

	public static Cronograma fromDTOToEntity(CronogramaDTO cronogramaDTO) {
		return Cronograma.builder()
				.horaFechamento(cronogramaDTO.getHoraFechamento())
				.horaAbertura(cronogramaDTO.getHoraAbertura())
				.diaSemana(cronogramaDTO.getDiaSemana())
				.build();
	}

	public static CronogramaDTO fromEntityToDTO(Cronograma cronograma) {
		return CronogramaDTO.builder()
				.horaFechamento(cronograma.getHoraFechamento())
				.horaAbertura(cronograma.getHoraAbertura())
				.diaSemana(cronograma.getDiaSemana())
				.build();
	}

}
