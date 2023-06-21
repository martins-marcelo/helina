package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.adapter.db.UsuarioDBClient;
import com.martins.helina.entrypoint.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CadastrarUsuarioUseCase {
	
	private final UsuarioDBClient usuarioClient;
	
	public UsuarioDTO execute(UsuarioDTO usuarioDTO) {
		return usuarioClient.inserirUsuario(usuarioDTO);
		
	}
}
