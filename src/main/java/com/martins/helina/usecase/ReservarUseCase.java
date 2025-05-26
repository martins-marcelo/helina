package com.martins.helina.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.martins.helina.adapter.sns.ReservaSNSClient;
import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.controller.dto.ReservaDTO;
import com.martins.helina.controller.dto.enums.StatusReservaEnum;
import com.martins.helina.controller.dto.enums.TipoReservaEnum;
import com.martins.helina.service.EstabelecimentoService;
import com.martins.helina.service.ReservaService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReservarUseCase {

	private final EstabelecimentoService estabelecimentoService;
	private final ReservaService reservaService;
	private final ReservaSNSClient reservaSNSClient;

	
	public void execute(ReservaDTO reservaDTO) throws Exception{
	
		EstabelecimentoDTO estabelecimento = estabelecimentoService.buscarPorId(reservaDTO.getIdEstabelecimento());
		if(!podeReservar(estabelecimento.getReservas(), estabelecimento.getTotalVagas(), reservaDTO.getQuantidadePessoas()))
			throw new Exception("Fully booked");

		if(estabelecimento.getTipoReserva().equals(TipoReservaEnum.RESERVA_AUTO.name())) {
			reservaDTO.setStatus(StatusReservaEnum.ACEITA);
		}
		else {
			reservaDTO.setStatus(StatusReservaEnum.SOLICITADA);
		}
		reservaService.criar(reservaDTO);
		reservaSNSClient.notificarReservaEstabelecimento();
	}

	private Boolean podeReservar(List<ReservaDTO> reservas, Integer quantidadeMaxima, Integer quantidadePessoas) {
		Integer jaReservado = reservas.stream()
		.map(ReservaDTO::getQuantidadePessoas)
		.reduce(0, (a, b) -> a + b);
		if(quantidadePessoas <= (quantidadeMaxima - jaReservado))
			return true;
		return false;
	}

}
