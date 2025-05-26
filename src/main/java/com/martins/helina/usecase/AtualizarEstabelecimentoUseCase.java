package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.exception.ObjectNotFoundException;
import com.martins.helina.service.EstabelecimentoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AtualizarEstabelecimentoUseCase {
	
	private final EstabelecimentoService estabelecimentoService;
	
	public EstabelecimentoDTO execute(EstabelecimentoDTO estabelecimentoDTO) throws ObjectNotFoundException{
		return estabelecimentoService.atualizar(estabelecimentoDTO);
	}

}
