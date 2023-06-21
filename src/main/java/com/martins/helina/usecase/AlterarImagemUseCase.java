package com.martins.helina.usecase;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.martins.helina.adapter.s3.ImagemS3Adapter;

@Component
public class AlterarImagemUseCase {
	
	@Autowired
	ImagemS3Adapter imagemAdapter;
	
	public void execute(Long idUsuario, MultipartFile fotoPerfil) {
		try {
            File fotoPerfilFile = imagemAdapter.convertMultipartFileToFile(fotoPerfil);
            String objectKey = "usuarios/" + idUsuario + "/foto_perfil.jpg";
            imagemAdapter.sendFotoPerfil(objectKey, fotoPerfilFile);            
            fotoPerfilFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
}
