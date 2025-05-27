package com.martins.helina.adapter.s3;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.martins.helina.config.SecretsManagerService;
import com.martins.helina.exception.ImagemNaoEncontradaException;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

@Service
public class ImagemS3Adapter implements ImagemS3Client{
	
	private String bucketName;	
	private S3Client s3Client;
	
	public ImagemS3Adapter(S3Adapter s3Adapter, SecretsManagerService secretsManagerService) {
        this.s3Client = s3Adapter.getS3Client();
        this.bucketName = secretsManagerService.getSecretValue("S3_BUCKET_NAME");
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
    public byte[] recuperarFotoPerfil(String idUsuario) throws ImagemNaoEncontradaException, RuntimeException{
        String objectKey = "usuarios/" + idUsuario + "/foto_perfil.jpg";
        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();

        try {
            return s3Client.getObjectAsBytes(request).asByteArray();
        } catch (NoSuchKeyException e) {
            throw new ImagemNaoEncontradaException(
                String.format("Imagem não encontrada para o usuário: %s", idUsuario)
            );
        } catch (S3Exception e) {
            throw new RuntimeException("Erro ao acessar S3: " + e.awsErrorDetails().errorMessage(), e);
        }
    }

	@Override
    public byte[] recuperarImagemEstabelecimento(Long idEstabelecimento, Boolean isBanner) {
        String nameFile = isBanner ? "banner" : "icon";
        String objectKey = "estabelecimentos/" + idEstabelecimento + "/" + nameFile + ".jpg";

        GetObjectRequest request = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(objectKey)
                .build();

        try {
            var response = s3Client.getObject(request);
            return response.readAllBytes();
        } catch (software.amazon.awssdk.services.s3.model.NoSuchKeyException e) {
            throw new ImagemNaoEncontradaException(
                String.format("Imagem '%s' do estabelecimento de id %d não encontrada.", nameFile, idEstabelecimento)
            );
        } catch (IOException e) {
            throw new RuntimeException("Erro ao processar a imagem do estabelecimento.", e);
        }
    }
	
	
	
	@Override
	public File convertMultipartFileToFile(MultipartFile file) throws IOException {
        return new File(file.getOriginalFilename());
    }

	
	
}
