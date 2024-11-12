package kr.co.bongdamsafety.onlinemap.service;

import jakarta.annotation.PostConstruct;
import net.nurigo.sdk.message.service.DefaultMessageService;

import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service
@Component
public class SMSService {

    @Value("${coolsms.apikey}")
    private String apiKey;

    @Value("${coolsms.apisecret}")
    private String apiSecret;

    @Value("${coolsms.fromnumber}")
    private String fromNumber;

    DefaultMessageService messageService;
    @PostConstruct
    public void init() {
        this.messageService = NurigoApp.INSTANCE.initialize(apiKey,apiSecret,"https://api.coolsms.co.kr");
    }

    public SingleMessageSentResponse sendMessage(String to, String messagetext) {
        Message message = new Message();
        message.setFrom(fromNumber);
        message.setTo(to);
        message.setText(messagetext);

        return messageService.sendOne(new SingleMessageSendingRequest(message));
    }
}
