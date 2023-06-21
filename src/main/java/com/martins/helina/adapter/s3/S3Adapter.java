package com.martins.helina.adapter.s3;

import org.springframework.stereotype.Component;

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Component
public class S3Adapter {
	
	public S3Client getS3Client() {
        return S3Client.builder()
                .region(Region.SA_EAST_1)
                .credentialsProvider(DefaultCredentialsProvider.create())
                .build();
    }
}
