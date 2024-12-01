package kr.co.bongdamsafety.onlinemap.api;

//@RestController

public class ImageUploadController {
    /*
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
            return ResponseEntity.status(500).body("file upload failed");
        }

        OCRForm OCRresult = OCRService.extractTextfromImage(dest);

        String password = null;
        if (OCRresult != null) {
            password = OCRresult.getPhonenumber().length() >= 5
                    ? OCRresult.getPhonenumber().substring(OCRresult.getPhonenumber().length() - 4)
                    : OCRresult.getPhonenumber();
            String messagetext = String.format("%s님, 송장번호 %s의 택배가 도착하였습니다. 비밀번호: %s", OCRresult.getName(), OCRresult.getTrackingnumber(),password);
            smsService.sendMessage(OCRresult.getPhonenumber(), messagetext);
        }

        //dest.delete();
        return ResponseEntity.ok(password);
    }

     */
}
