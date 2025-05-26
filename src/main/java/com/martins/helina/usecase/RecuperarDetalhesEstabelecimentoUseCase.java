package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.exception.ObjectNotFoundException;
import com.martins.helina.service.EstabelecimentoService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecuperarDetalhesEstabelecimentoUseCase {
	
	private final EstabelecimentoService service;
	public EstabelecimentoDTO execute(String idEstabelecimento) throws ObjectNotFoundException {
		var estab = service.buscarPorId(idEstabelecimento);
		return estab;
		
	}
}
