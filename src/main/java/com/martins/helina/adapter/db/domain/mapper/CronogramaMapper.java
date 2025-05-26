package com.martins.helina.adapter.db.domain.mapper;

import com.martins.helina.adapter.db.domain.Cronograma;
import com.martins.helina.controller.dto.CronogramaDTO;

public class CronogramaMapper {

	public static Cronograma fromDTOToEntity(CronogramaDTO cronogramaDTO) {
		return Cronograma.builder()
				.hrFim(cronogramaDTO.getHrFim())
				.hrInicio(cronogramaDTO.getHrInicio())
				.idCronograma(cronogramaDTO.getIdCronograma())
				.nmDia(cronogramaDTO.getNmDia())
				.build();
	}

	public static CronogramaDTO fromEntityToDTO(Cronograma cronograma) {
		return CronogramaDTO.builder()
				.hrFim(cronograma.getHrFim())
				.hrInicio(cronograma.getHrInicio())
				.idCronograma(cronograma.getIdCronograma())
				.nmDia(cronograma.getNmDia())
				.build();
	}

}
