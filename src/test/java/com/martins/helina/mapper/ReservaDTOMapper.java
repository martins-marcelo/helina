package com.martins.helina.mapper;

import com.martins.helina.entrypoint.dto.ReservaDTO;
import com.martins.helina.entrypoint.dto.enums.StatusReservaEnum;

public class ReservaDTOMapper {

    public ReservaDTO reservaDTOMapperStatusAceita(){
        return ReservaDTO.builder()
                .idEstabelecimento(1L)
                .statusReserva(StatusReservaEnum.ACEITA)
                .idReserva(1L)
                .idUsuario(1L)
                .quantidade(10)
                .build();

    }
    public ReservaDTO reservaDTOMapperStatusSolicitada(){
        return ReservaDTO.builder()
                .idEstabelecimento(1L)
                .statusReserva(StatusReservaEnum.SOLICITADA)
                .idReserva(1L)
                .idUsuario(1L)
                .quantidade(10)
                .build();
    }
}
