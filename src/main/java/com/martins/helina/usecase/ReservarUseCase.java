package com.martins.helina.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.martins.helina.adapter.db.EstabelecimentoDBClient;
import com.martins.helina.adapter.db.ReservaDBClient;
import com.martins.helina.adapter.sns.ReservaSNSClient;
import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.controller.dto.ReservaDTO;
import com.martins.helina.controller.dto.enums.StatusReservaEnum;
import com.martins.helina.controller.dto.enums.TipoReservaEnum;

@Component
@RequiredArgsConstructor
public class ReservarUseCase {

	private final EstabelecimentoDBClient estabelecimentoClient;
	private final ReservaDBClient reservaDBClient;
	private final ReservaSNSClient reservaSNSClient;

	
	public ReservaDTO execute(ReservaDTO reservaDTO) throws Exception{
	
		EstabelecimentoDTO estabelecimento = estabelecimentoClient.recuperarEstabelecimento(reservaDTO.getIdEstabelecimento());
		
		if(estabelecimento.getTipoReserva().equals(TipoReservaEnum.RESERVA_AUTO.name())) {
			reservaDTO.setStatusReserva(StatusReservaEnum.ACEITA);
		}
		else {
			reservaDTO.setStatusReserva(StatusReservaEnum.SOLICITADA);
		}
		reservaDTO = reservaDBClient.inserirReserva(reservaDTO);
		reservaSNSClient.notificarReservaEstabelecimento();
		return reservaDTO;
	}

}
