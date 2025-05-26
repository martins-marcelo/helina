package com.martins.helina.controller.dto;

import com.martins.helina.controller.dto.enums.StatusReservaEnum;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class ReservaDTO {
private String idReserva;
    private String idUsuario;
    private String idEstabelecimento;
    private String nomeUsuario;
    private String dataHoraReserva;
    private Integer quantidadePessoas;
    private StatusReservaEnum status;
}
