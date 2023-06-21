package com.martins.helina.entrypoint.dto;

import com.martins.helina.entrypoint.dto.enums.StatusReservaEnum;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ReservaDTO {
	
	private Long idReserva;
	
	private Long idUsuario;
	
	private Long idEstabelecimento;
	
	private Integer quantidade;
	
	private StatusReservaEnum statusReserva;

}
