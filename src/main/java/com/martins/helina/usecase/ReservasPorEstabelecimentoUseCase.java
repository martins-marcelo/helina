package com.martins.helina.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.controller.dto.ReservaDTO;
import com.martins.helina.service.EstabelecimentoService;
import com.martins.helina.service.ReservaService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReservasPorEstabelecimentoUseCase {

	private final EstabelecimentoService estabelecimentoService;
	private final ReservaService reservaService;
	
	public List<ReservaDTO> execute(String idEstabelecimento) throws Exception{
		
		EstabelecimentoDTO estabelecimento = estabelecimentoService.buscarPorId(idEstabelecimento);
		if(estabelecimento != null)
			return reservaService.buscarReservasPorIdEstabelecimento(idEstabelecimento);
		return null;
		
	}

}
