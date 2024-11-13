package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.OCRForm;
import kr.co.bongdamsafety.onlinemap.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

    private final SMSService smsService;
    @Autowired
    public SMSController(SMSService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/api/send-sms")
    public ResponseEntity<String> sendSms(@RequestBody OCRForm ocrForm) {
        String phonenumber = ocrForm.getPhonenumber();
        String trackingnumber = ocrForm.getTrackingnumber();
        String name = ocrForm.getName();

        String messagetext = String.format("%s님, 송장번호 %s의 택배가 도착하였습니다", name, trackingnumber);
        smsService.sendMessage(phonenumber,messagetext);

        return ResponseEntity.ok("sms 전송 성공");
    }
}
