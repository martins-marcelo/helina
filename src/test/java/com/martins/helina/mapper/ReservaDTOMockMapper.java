package com.martins.helina.mapper;

import com.martins.helina.controller.dto.ReservaDTO;
import com.martins.helina.controller.dto.enums.StatusReservaEnum;

public class ReservaDTOMockMapper {

    public ReservaDTO reservaDTOMapperStatusAceita(){
        return ReservaDTO.builder()
                .idEstabelecimento("1")
                .status(StatusReservaEnum.ACEITA)
                .idReserva("1")
                .idUsuario("1")
                .quantidadePessoas(10)
                .build();

    }
    public ReservaDTO reservaDTOMapperStatusSolicitada(){
        return ReservaDTO.builder()
                .idEstabelecimento("1")
                .status(StatusReservaEnum.SOLICITADA)
                .idReserva("1")
                .idUsuario("1")
                .quantidadePessoas(10)
                .build();
    }
}
