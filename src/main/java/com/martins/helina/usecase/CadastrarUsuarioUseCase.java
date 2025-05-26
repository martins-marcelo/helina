package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.controller.dto.UsuarioDTO;
import com.martins.helina.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {
	
	private final UsuarioService service;
	
	public void execute(UsuarioDTO usuarioDTO) throws Exception {
		service.criar(usuarioDTO);
		
	}
}
