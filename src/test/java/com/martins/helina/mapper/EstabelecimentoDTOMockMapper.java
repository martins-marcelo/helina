package com.martins.helina.mapper;

import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.controller.dto.enums.TipoReservaEnum;

public class EstabelecimentoDTOMockMapper {

    public EstabelecimentoDTO estabelecimentoDTOMapperTipoReservaAuto(){
        return EstabelecimentoDTO.builder()
                .tipoReserva(TipoReservaEnum.RESERVA_AUTO.name())
                .build();
    }
    public EstabelecimentoDTO estabelecimentoDTOMapperTipoReservaAvaliar(){
        return EstabelecimentoDTO.builder()
                .tipoReserva(TipoReservaEnum.AVALIAR_RESERVA.name())
                .build();
    }


}
