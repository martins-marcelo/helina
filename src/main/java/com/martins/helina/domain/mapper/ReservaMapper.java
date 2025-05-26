package com.martins.helina.domain.mapper;

import java.util.Optional;

import com.martins.helina.controller.dto.ReservaDTO;
import com.martins.helina.controller.dto.enums.StatusReservaEnum;
import com.martins.helina.domain.Reserva;

public class ReservaMapper {
	
	public static Reserva fromDTOToEntity(ReservaDTO dto) {
		return Reserva.builder()
				.idReserva(Optional.ofNullable(dto.getIdReserva()).orElse(null))
				.idUsuario(dto.getIdUsuario())
				.nomeUsuario(dto.getNomeUsuario())
				.dataHoraReserva(dto.getDataHoraReserva())
				.quantidadePessoas(dto.getQuantidadePessoas())
				.status(dto.getStatus().name())
				.build();
	}
	
	public static ReservaDTO fromEntityToDTO(Reserva reserva) {
		return ReservaDTO.builder()
				.idReserva(Optional.ofNullable(reserva.getIdReserva()).orElse(null))
				.idUsuario(reserva.getIdUsuario())
				.nomeUsuario(reserva.getNomeUsuario())
				.dataHoraReserva(reserva.getDataHoraReserva())
				.quantidadePessoas(reserva.getQuantidadePessoas())
				.status(StatusReservaEnum.valueOf(reserva.getStatus()))
				.build();
	}

}
