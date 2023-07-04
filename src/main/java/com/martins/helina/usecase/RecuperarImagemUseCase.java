package com.martins.helina.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.martins.helina.adapter.s3.ImagemS3Adapter;

@Component
@RequiredArgsConstructor
public class RecuperarImagemUseCase {
	
	private final ImagemS3Adapter imagemAdapter;
	
	public byte[] execute(Long idUsuario) {
		return imagemAdapter.recuperarFotoPerfil(idUsuario);
	}
}
