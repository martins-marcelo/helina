package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.adapter.db.EstabelecimentoDBClient;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;
import com.martins.helina.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecuperarDetalhesEstabelecimentoUseCase {
	
	private final EstabelecimentoDBClient dbClient;
	public EstabelecimentoDTO execute(Long idEstabelecimento) throws ObjectNotFoundException {
		return dbClient.recuperarEstabelecimento(idEstabelecimento);
		
	}
}
