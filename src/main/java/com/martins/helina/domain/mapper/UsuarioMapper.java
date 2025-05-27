package com.martins.helina.domain.mapper;

import java.util.stream.Collectors;

import com.martins.helina.controller.dto.UsuarioDTO;
import com.martins.helina.controller.dto.enums.Perfil;
import com.martins.helina.domain.Usuario;

public class UsuarioMapper {

	public static Usuario fromDTOToEntity(UsuarioDTO usuarioDTO) {
		return Usuario.builder()
				.id(usuarioDTO.getId())
				.email(usuarioDTO.getEmail())
				.endereco(EnderecoMapper.fromDTOToEntity(usuarioDTO.getEndereco()))
				.nome(usuarioDTO.getNome())
				.telefone(usuarioDTO.getTelefone())
				.senha(usuarioDTO.getSenha())
				.perfis(usuarioDTO.getPerfis()
					.stream()
					.map(Perfil::getCodigo)
					.collect(Collectors.toSet()))
				.build();
	}

	public static UsuarioDTO fromEntityToDTO(Usuario usuario) {
		return UsuarioDTO.builder()
				.email(usuario.getEmail())
				.endereco(EnderecoMapper.fromEntityToDTO(usuario.getEndereco()))
				.id(usuario.getId())
				.nome(usuario.getNome())
				.telefone(usuario.getTelefone())
				.build();
	}

}
