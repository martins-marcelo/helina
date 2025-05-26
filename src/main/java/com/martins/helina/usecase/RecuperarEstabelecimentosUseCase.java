package com.martins.helina.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.martins.helina.adapter.db.EstabelecimentoDBClient;
import com.martins.helina.controller.dto.EstabelecimentoDTO;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecuperarEstabelecimentosUseCase {
	
	private final EstabelecimentoDBClient estabelecimentoDBClient;
	
	public List<EstabelecimentoDTO> execute() {
		
		return estabelecimentoDBClient.listarEstabelecimentos();
		
	}
}
