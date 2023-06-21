package com.martins.helina.adapter.db;

import com.martins.helina.ObjectNotFoundException;
import com.martins.helina.entrypoint.dto.UsuarioDTO;

public interface UsuarioDBClient {
	
	UsuarioDTO inserirUsuario(UsuarioDTO usuarioDTO);
	
	UsuarioDTO recuperarDetalhesUsuario(Long idUsuario) throws ObjectNotFoundException;
}
