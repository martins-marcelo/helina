package com.martins.helina.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

import javax.annotation.PostConstruct;
import java.util.Map;

@Slf4j
@Service
@Getter
public class SecretsManagerService {

    private Map<String, String> secrets;

    private final String secretName = "/helina/app/prod";
    private final Region region = Region.SA_EAST_1;

    @PostConstruct
    public void init() {
        log.info("Fetching secrets from AWS Secrets Manager...");
        this.secrets = fetchSecrets();
        log.info("Secrets loaded successfully.");
    }

    private Map<String, String> fetchSecrets() {
        try (SecretsManagerClient client = SecretsManagerClient.builder()
                .region(region)
                .build()) {

            GetSecretValueRequest request = GetSecretValueRequest.builder()
                    .secretId(secretName)
                    .build();

            GetSecretValueResponse response = client.getSecretValue(request);

            String secretString = response.secretString();

            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(secretString, new TypeReference<>() {});
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch secrets from AWS Secrets Manager", e);
        }
    }

    public String getSecretValue(String key) {
        return secrets.get(key);
    }
}
