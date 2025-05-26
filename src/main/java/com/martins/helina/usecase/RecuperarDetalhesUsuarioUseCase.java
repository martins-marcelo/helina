package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.adapter.db.UsuarioDBClient;
import com.martins.helina.adapter.s3.ImagemS3Client;
import com.martins.helina.controller.dto.UsuarioDTO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecuperarDetalhesUsuarioUseCase {
	
	private final UsuarioDBClient usuarioDBClient;
	
	private final ImagemS3Client imagemS3Client;
	
	public UsuarioDTO execute(Long idUsuario) {
		var usuarioDTO = usuarioDBClient.recuperarDetalhesUsuario(idUsuario);
		usuarioDTO.setFotoPerfil(imagemS3Client.recuperarFotoPerfil(idUsuario));
		return usuarioDTO;
		
	}
}
