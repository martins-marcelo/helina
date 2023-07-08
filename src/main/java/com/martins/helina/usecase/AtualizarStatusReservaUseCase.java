package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.adapter.db.ReservaDBClient;
import com.martins.helina.adapter.sns.ReservaSNSClient;
import com.martins.helina.entrypoint.dto.ReservaDTO;
import com.martins.helina.entrypoint.dto.enums.Perfil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtualizarStatusReservaUseCase {
	private final ReservaDBClient reservaDBClient;
	private final ReservaSNSClient reservaSNSClient;

	public ReservaDTO execute(ReservaDTO reservaDTO) throws Exception {
		var resposta = reservaDBClient.atualizarStatusReserva(reservaDTO);
		if (Perfil.toEnum(reservaDTO.getSolicitante()).equals(Perfil.CLIENTE_USER)) 
			reservaSNSClient.notificarReservaEstabelecimento();
		else
			reservaSNSClient.notificarStatusReservaCliente();
		return resposta;
	}

}
