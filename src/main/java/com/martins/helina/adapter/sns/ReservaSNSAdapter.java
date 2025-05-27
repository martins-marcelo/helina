package com.martins.helina.adapter.sns;

import org.springframework.stereotype.Service;

import com.martins.helina.config.SecretsManagerService;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class ReservaSNSAdapter implements ReservaSNSClient{
	
	private SnsClient snsClient;
	
	private static final String MSG_RESERVA = "Nova reserva recebida para seu estabelecimento!";
	
	private String topicArn;
	
	public ReservaSNSAdapter(SNSAdapter snsAdapter, SecretsManagerService secretsManagerService) {
        this.snsClient = snsAdapter.getSNSClient();
		this.topicArn = secretsManagerService.getSecretValue("SNS_TOPIC_ARN");
    }
	
	@Override
	public void notificarReservaEstabelecimento() {
		PublishRequest request = PublishRequest.builder()
                .topicArn(topicArn)
                .message(MSG_RESERVA)
                .build();
       snsClient.publish(request);
		
	}

	@Override
	public void notificarStatusReservaCliente() {
		// TODO Auto-generated method stub
		
	}
	
	
}
