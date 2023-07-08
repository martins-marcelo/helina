package com.martins.helina.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.martins.helina.adapter.db.EstabelecimentoDBClient;
import com.martins.helina.adapter.db.ReservaDBClient;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;
import com.martins.helina.entrypoint.dto.ReservaDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ReservasPorEstabelecimentoUseCase {

	private final EstabelecimentoDBClient estabelecimentoClient;
	private final ReservaDBClient reservaDBClient;

	
	public List<ReservaDTO> execute(Long idEstabelecimento) throws Exception{
		
		EstabelecimentoDTO estabelecimento = estabelecimentoClient.recuperarEstabelecimento(idEstabelecimento);
		if(estabelecimento != null)
			return reservaDBClient.recuperarReservasPorEstabelecimento(idEstabelecimento);
		return null;
		
	}

}
