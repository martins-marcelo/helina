package com.martins.helina.adapter.db;

import com.martins.helina.controller.dto.UsuarioDTO;
import com.martins.helina.exception.ObjectNotFoundException;

public interface UsuarioDBClient {
	
	UsuarioDTO inserirUsuario(UsuarioDTO usuarioDTO) throws Exception;
	
	UsuarioDTO recuperarDetalhesUsuario(Long idUsuario) throws ObjectNotFoundException;
}
