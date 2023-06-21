package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.adapter.db.EstabelecimentoDBClient;
import com.martins.helina.entrypoint.dto.EstabelecimentoDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarEstabelecimentoUseCase {
	
	private final EstabelecimentoDBClient estabelecimentoDBClient;
	
	public EstabelecimentoDTO execute(EstabelecimentoDTO estabelecimentoDTO) {
		return estabelecimentoDBClient.cadastrarEstabelecimento(estabelecimentoDTO);
		
	}
}
