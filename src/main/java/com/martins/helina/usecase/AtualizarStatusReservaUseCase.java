package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.adapter.sns.ReservaSNSClient;
import com.martins.helina.controller.dto.ReservaDTO;
import com.martins.helina.service.ReservaService;
import com.martins.helina.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtualizarStatusReservaUseCase {
	private final ReservaService reservaService;
	private final ReservaSNSClient reservaSNSClient;
	private final UsuarioService usuarioService;

	public Boolean execute(ReservaDTO reservaDTO) throws Exception {
		var resposta = reservaService.atualizarStatusReserva(reservaDTO);
		Boolean isCliente = usuarioService.isUsuarioCliente(reservaDTO.getIdUsuario());
		if (isCliente) 
			reservaSNSClient.notificarReservaEstabelecimento();
		else
			reservaSNSClient.notificarStatusReservaCliente();
		return resposta;
	}

}
