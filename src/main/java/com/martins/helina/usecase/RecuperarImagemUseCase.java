package com.martins.helina.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.martins.helina.adapter.s3.ImagemS3Adapter;

@Component
public class RecuperarImagemUseCase {
	
	@Autowired
	ImagemS3Adapter imagemAdapter;
	
	public byte[] execute(Long idUsuario) {
		return imagemAdapter.recuperarFotoPerfil(idUsuario);
	}
}
