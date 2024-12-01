package kr.co.bongdamsafety.onlinemap.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component
public class SMSService {
    /*
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

     */
}
