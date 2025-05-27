package com.martins.helina.adapter.s3;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.martins.helina.exception.ImagemNaoEncontradaException;

public interface ImagemS3Client {
	
	File convertMultipartFileToFile(MultipartFile file) throws IOException;
	
	void sendFotoPerfil(String objectKey, File fotoPerfil) throws IOException;
	
	byte[] recuperarFotoPerfil(String idUsuario) throws ImagemNaoEncontradaException, RuntimeException;
	
	byte[] recuperarImagemEstabelecimento(Long idEstabelecimento, Boolean isBanner);

}
