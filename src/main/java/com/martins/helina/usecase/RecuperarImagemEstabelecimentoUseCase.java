package com.martins.helina.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.martins.helina.adapter.s3.ImagemS3Adapter;

@Component
public class RecuperarImagemEstabelecimentoUseCase {
	
	@Autowired
	ImagemS3Adapter imagemAdapter;
	
	public byte[] execute(Long idUsuario, String flBanner) {
		Boolean isBanner = flBanner.equals("S") ? true : false;
		return imagemAdapter.recuperarImagemEstabelecimento(idUsuario, isBanner);
	}
}
