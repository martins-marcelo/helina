package com.martins.helina.adapter.db.domain;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cronograma {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCronograma;
	
	private String nmDia;

	private LocalTime hrInicio;

	private LocalTime hrFim;

}
