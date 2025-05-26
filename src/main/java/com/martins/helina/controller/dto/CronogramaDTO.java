package com.martins.helina.controller.dto;

import java.time.LocalTime;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class CronogramaDTO {
	
private Long idCronograma;
	
	private String nmDia;

	private LocalTime hrInicio;

	private LocalTime hrFim;
}
