package com.martins.helina.usecase;

import java.util.List;

import org.springframework.stereotype.Component;

import com.martins.helina.controller.dto.EstabelecimentoDTO;
import com.martins.helina.service.EstabelecimentoService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RecuperarEstabelecimentosUseCase {
	
	private final EstabelecimentoService service;
	
	public List<EstabelecimentoDTO> execute() {
		
		return service.listarTodos();
		
	}
}
