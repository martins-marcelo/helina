package com.martins.helina.adapter.db.domain;

import java.time.LocalDateTime;

import com.martins.helina.entrypoint.dto.enums.StatusReservaEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Entity @Builder @Getter @Setter
public class Reserva {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReserva;
	
	private Long idEstabelecimento;
	
	private Long idUsuario;
	
	private String nomeReserva;
	
	private LocalDateTime dtHoraReserva;
	
	private Integer qtVagasReserva;
	
	private StatusReservaEnum statusReserva;
}
