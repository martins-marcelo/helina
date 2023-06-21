package com.martins.helina.adapter.db;

import com.martins.helina.entrypoint.dto.UsuarioDTO;
import com.martins.helina.exceptions.ObjectNotFoundException;

public interface UsuarioDBClient {
	
	UsuarioDTO inserirUsuario(UsuarioDTO usuarioDTO);
	
	UsuarioDTO recuperarDetalhesUsuario(Long idUsuario) throws ObjectNotFoundException;
}
