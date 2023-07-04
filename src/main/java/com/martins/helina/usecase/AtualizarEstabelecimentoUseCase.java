package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.adapter.db.EstabelecimentoDBClient;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;
import com.martins.helina.exceptions.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtualizarEstabelecimentoUseCase {
	
	private final EstabelecimentoDBClient estabelecimentoDBClient;
	
	public EstabelecimentoDTO execute(EstabelecimentoDTO estabelecimentoDTO) throws ObjectNotFoundException{
		return null;
	}

}
