package com.martins.helina.usecase;

import org.springframework.stereotype.Component;

import com.martins.helina.adapter.db.EstabelecimentoDBClient;
import com.martins.helina.adapter.db.ReservaDBClient;
import com.martins.helina.adapter.sns.ReservaSNSClient;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;
import com.martins.helina.entrypoint.dto.ReservaDTO;
import com.martins.helina.entrypoint.dto.enums.StatusReservaEnum;
import com.martins.helina.entrypoint.dto.enums.TipoReservaEnum;

@Component
public class ReservarUseCase {
	
	EstabelecimentoDBClient estabelecimentoClient;
	ReservaDBClient reservaDBClient;
	ReservaSNSClient reservaSNSClient;
	
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
