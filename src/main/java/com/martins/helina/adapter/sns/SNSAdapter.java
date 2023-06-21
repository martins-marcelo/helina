package com.martins.helina.adapter.sns;

import org.springframework.stereotype.Component;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

@Component
public class SNSAdapter {
	
	public SnsClient getSNSClient() {
        return SnsClient.builder()
                .region(Region.SA_EAST_1)
                .build();
    }
}
