package com.martins.helina.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
public class AwsConfig {

    private final SecretsManagerService secretsManagerService;

    public AwsConfig(SecretsManagerService secretsManagerService) {
        this.secretsManagerService = secretsManagerService;
    }

    private String getRegion() {
        return secretsManagerService.getSecretValue("AWS_REGION");
    }

    private StaticCredentialsProvider credentialsProvider() {
        String accessKey = secretsManagerService.getSecretValue("AWS_ACCESS_KEY_ID");
        String secretKey = secretsManagerService.getSecretValue("AWS_SECRET_ACCESS_KEY");
        return StaticCredentialsProvider.create(
                AwsBasicCredentials.create(accessKey, secretKey)
        );
    }

    // DynamoDB
    @Bean
    public DynamoDbClient dynamoDbClient() {
        return DynamoDbClient.builder()
                .region(Region.of(getRegion()))
                .credentialsProvider(credentialsProvider())
                .build();
    }

    @Bean
    public DynamoDbEnhancedClient dynamoDbEnhancedClient(DynamoDbClient dynamoDbClient) {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(dynamoDbClient)
                .build();
    }

    // S3
    @Bean
    public S3Client s3Client() {
        return S3Client.builder()
                .region(Region.of(getRegion()))
                .credentialsProvider(credentialsProvider())
                .build();
    }

    // SNS
    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder()
                .region(Region.of(getRegion()))
                .credentialsProvider(credentialsProvider())
                .build();
    }
}
