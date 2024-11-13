package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.OCRForm;
import kr.co.bongdamsafety.onlinemap.service.OCRService;
import kr.co.bongdamsafety.onlinemap.service.SMSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@RestController

public class ImageUploadController {
    @Autowired
    private OCRService ocrService;
    @Autowired
    private SMSService smsService;
    @PostMapping("api/upload")
    public ResponseEntity<String> handleImageUpload(@RequestParam("file") MultipartFile file) {
        String filepath = new File("src/main/resources/uploads/").getAbsolutePath() + "/" + file.getOriginalFilename();
        File dest = new File(filepath);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("file upload failed");
        }

        OCRForm OCRresult = OCRService.extractTextfromImage(dest);

        if(OCRresult!=null){
            String messagetext = String.format("%s님, 송장번호 %s의 택배가 도착하였습니다", OCRresult.getName(), OCRresult.getTrackingnumber());
            smsService.sendMessage(OCRresult.getPhonenumber(),messagetext);
        }

        dest.delete();
        return ResponseEntity.ok("ocr 및 문자 전송 성공");
    }
}
