package com.martins.helina.adapter.sns;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
public class ReservaSNSAdapter implements ReservaSNSClient{
	
	private SnsClient snsClient;
	
	private static final String MSG_RESERVA = "Nova reserva recebida pelo seu estabelecimento!";
	
	@Value("${topic.arn}")
	private String topicArn;
	
	public ReservaSNSAdapter(SNSAdapter snsAdapter) {
        this.snsClient = snsAdapter.getSNSClient();
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
