package com.martins.helina.usecase;

import org.springframework.stereotype.Service;

import com.martins.helina.adapter.s3.ImagemS3Client;
import com.martins.helina.controller.dto.UsuarioDTO;
import com.martins.helina.exception.ImagemNaoEncontradaException;
import com.martins.helina.service.UsuarioService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecuperarDetalhesUsuarioUseCase {
	
	private final UsuarioService usuarioService;
	
	private final ImagemS3Client imagemS3Client;
	
	public UsuarioDTO execute(String idUsuario) {
		var usuarioDTO = usuarioService.buscarPorId(idUsuario);
		try{
			usuarioDTO.setFotoPerfil(imagemS3Client.recuperarFotoPerfil(idUsuario));
		}
		catch(ImagemNaoEncontradaException inee) {
			usuarioDTO.setFotoPerfil(null);
		}
		return usuarioDTO;
		
	}
}
