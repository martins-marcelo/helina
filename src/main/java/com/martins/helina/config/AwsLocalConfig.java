package com.martins.helina.config;

import java.net.URI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sns.SnsClient;

@Profile("local")
@Configuration
public class AwsLocalConfig {

    private static final String LOCALSTACK_ENDPOINT = "http://localhost:4566";
    private static final Region REGION = Region.of("sa-east-1");
    private static final StaticCredentialsProvider CREDENTIALS = StaticCredentialsProvider.create(
            AwsBasicCredentials.create("test", "test")
    );

    // DynamoDB
    @Bean
    public DynamoDbClient dynamoDbClientLocal() {
        return DynamoDbClient.builder()
                .endpointOverride(URI.create(LOCALSTACK_ENDPOINT))
                .region(REGION)
                .credentialsProvider(CREDENTIALS)
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClientLocal(DynamoDbClient dynamoDbClientLocal) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClientLocal)
                .build();
    }

    // S3
    @Bean
    public S3Client s3ClientLocal() {
        return S3Client.builder()
                .endpointOverride(URI.create(LOCALSTACK_ENDPOINT))
                .region(REGION)
                .credentialsProvider(CREDENTIALS)
                .forcePathStyle(true)
                .build();
    }

    // SNS
    @Bean
    public SnsClient snsClientLocal() {
        return SnsClient.builder()
                .endpointOverride(URI.create(LOCALSTACK_ENDPOINT))
                .region(REGION)
                .credentialsProvider(CREDENTIALS)
                .build();
    }
}
