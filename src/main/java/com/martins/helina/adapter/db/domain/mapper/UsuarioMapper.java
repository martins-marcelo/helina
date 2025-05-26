package com.martins.helina.adapter.db.domain.mapper;

import com.martins.helina.adapter.db.domain.Usuario;
import com.martins.helina.controller.dto.UsuarioDTO;

public class UsuarioMapper {

	public static Usuario fromDTOToEntity(UsuarioDTO usuarioDTO) {
		return Usuario.builder()
				.idUsuario(usuarioDTO.getIdUsuario())
				.emailUsuario(usuarioDTO.getEmailUsuario())
				.endereco(EnderecoMapper.fromDTOToEntity(usuarioDTO.getEndereco()))
				.nomeUsuario(usuarioDTO.getNomeUsuario())
				.build();
	}

	public static UsuarioDTO fromEntityToDTO(Usuario usuario) {
		return UsuarioDTO.builder()
				.emailUsuario(usuario.getEmailUsuario())
				.endereco(EnderecoMapper.fromEntityToDTO(usuario.getEndereco()))
				.idUsuario(usuario.getIdUsuario())
				.nomeUsuario(usuario.getNomeUsuario())
				.build();
	}

}
