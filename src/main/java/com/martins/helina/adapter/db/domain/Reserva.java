package com.martins.helina.adapter.db.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.martins.helina.entrypoint.dto.enums.StatusReservaEnum;

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
