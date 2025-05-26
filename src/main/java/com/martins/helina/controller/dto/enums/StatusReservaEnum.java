package com.martins.helina.controller.dto.enums;

import lombok.Getter;

@Getter
public enum StatusReservaEnum {
	
	SOLICITADA("A reserva foi solicitada e está em análise", 1),
	ACEITA("A sua reserva foi aceita", 2),
	CANCELADA("A sua reserva foi cancelada", 3);
	
	private String descricao;
	private Integer codigo;
	
	private StatusReservaEnum(String descricao, Integer codigo) {
		this.descricao = descricao;
		this.codigo = codigo;
	}

}
