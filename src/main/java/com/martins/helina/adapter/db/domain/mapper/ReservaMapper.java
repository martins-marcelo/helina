package com.martins.helina.adapter.db.domain.mapper;

import java.util.Optional;

import com.martins.helina.adapter.db.domain.Reserva;
import com.martins.helina.controller.dto.ReservaDTO;

public class ReservaMapper {
	
	public static Reserva fromDTOToEntity(ReservaDTO reservaDTO) {
		return Reserva.builder()
				.idReserva(Optional.ofNullable(reservaDTO.getIdReserva()).orElse(null))
				.idEstabelecimento(reservaDTO.getIdEstabelecimento())
				.idUsuario(reservaDTO.getIdUsuario())
				.statusReserva(reservaDTO.getStatusReserva())
				.build();
	}
	
	public static ReservaDTO fromEntityToDTO(Reserva reserva) {
		return ReservaDTO.builder()
				.idReserva(Optional.ofNullable(reserva.getIdReserva()).orElse(null))
				.idEstabelecimento(reserva.getIdEstabelecimento())
				.idUsuario(reserva.getIdUsuario())
				.statusReserva(reserva.getStatusReserva())
				.build();
	}

}
