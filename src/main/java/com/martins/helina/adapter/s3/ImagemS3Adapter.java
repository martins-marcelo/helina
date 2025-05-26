package com.martins.helina.adapter.s3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class ImagemS3Adapter implements ImagemS3Client{
	
	@Value("${s3.bucketName}")
	private String bucketName;
	
	private S3Client s3Client;
	
	public ImagemS3Adapter(S3Adapter s3Adapter) {
        this.s3Client = s3Adapter.getS3Client();
    }
	
	@Override
	public void sendFotoPerfil(String objectKey, File fotoPerfil) throws IOException {
		PutObjectRequest request = PutObjectRequest.builder()
        .bucket(bucketName)
        .key(objectKey)
        .build();
		s3Client.putObject(request, fotoPerfil.toPath());
	}
	
	@Override
	public byte[] recuperarFotoPerfil(String idUsuario) {
		String objectKey = "usuarios/" + idUsuario + "/foto_perfil.jpg";
        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();
        Path fotoPerfilPath;
        try {
            fotoPerfilPath = Files.createTempFile("foto_perfil", ".jpg");
            s3Client.getObject(request, fotoPerfilPath);
            byte[] fotoPerfilBytes = Files.readAllBytes(fotoPerfilPath);
            Files.delete(fotoPerfilPath);
            return fotoPerfilBytes;
        } catch (IOException e) {
           e.printStackTrace();
        }
        return null;
	}

	@Override
	public byte[] recuperarImagemEstabelecimento(Long idEstabelecimento, Boolean isBanner) {
		var nameFile = isBanner ? "banner" : "icon";
		String objectKey = "estabelecimentos/" + idEstabelecimento + "/" + nameFile + ".jpg";
        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();
        try {
            var resp = s3Client.getObject(request);
            byte[] fotoPerfilBytes = resp.readAllBytes();
            return fotoPerfilBytes;
        } catch (IOException e) {
           e.printStackTrace();
        }
        return null;
	}
	
	
	
	@Override
	public File convertMultipartFileToFile(MultipartFile file) throws IOException {
        return new File(file.getOriginalFilename());
    }

	
	
}
