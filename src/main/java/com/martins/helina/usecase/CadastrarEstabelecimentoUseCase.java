package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.service.EstabelecimentoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarEstabelecimentoUseCase {
	
	private final EstabelecimentoService service;
	
	public void execute(EstabelecimentoDTO estabelecimentoDTO) {
		service.criar(estabelecimentoDTO);
		
	}
}
