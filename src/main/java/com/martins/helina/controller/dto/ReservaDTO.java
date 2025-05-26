package com.martins.helina.controller.dto;

import com.martins.helina.controller.dto.enums.StatusReservaEnum;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ReservaDTO {
	
	private Long idReserva;
	
	private Long idUsuario;
	
	private Long idEstabelecimento;
	
	private Integer quantidade;
	
	private Integer solicitante;
	
	private StatusReservaEnum statusReserva;

}
