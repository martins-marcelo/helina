package com.martins.helina.entrypoint.dto.enums;

import lombok.Getter;

@Getter
public enum TipoReservaEnum {
	
	SEM_RESERVA("Nao optante", 1),
	AVALIAR_RESERVA("Optante por analise de reserva", 2),
	RESERVA_AUTO("Optante por reserva automatica", 3);
	
	private String descricao;
	private Integer codigo;
	
	private TipoReservaEnum(String descricao, Integer codigo) {
		this.descricao = descricao;
		this.codigo = codigo;
	}

}
