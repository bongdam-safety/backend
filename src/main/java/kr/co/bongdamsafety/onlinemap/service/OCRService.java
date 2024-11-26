package kr.co.bongdamsafety.onlinemap.service;

import kr.co.bongdamsafety.onlinemap.dto.OCRForm;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OCRService {
    public static OCRForm extractTextfromImage(File imagefile) {
        Tesseract tesseract = new Tesseract();
        String tessdataPath = new File("src/main/resources/tessdata").getAbsolutePath();
        tesseract.setDatapath(tessdataPath);
        tesseract.setLanguage("kor");
        try{
            String extractedText = tesseract.doOCR(imagefile);

            Pattern trackpattern = Pattern.compile("\\b\\d{10,12}\\b");
            Matcher trackmatcher = trackpattern.matcher(extractedText);
            String trackingnumber = trackmatcher.find() ? trackmatcher.group() : "fail";

            Pattern phonepattern = Pattern.compile("\\d{2,3}-\\d{3,4}-\\d{4}");
            Matcher phonematcher = phonepattern.matcher(extractedText);
            String phoneNumber = phonematcher.find() ? phonematcher.group() : "fail";

            Pattern namepattern = Pattern.compile("\\b[가-힣]{3}\\b");
            Matcher namematcher = namepattern.matcher(extractedText);
            String Name = namematcher.find() ? namematcher.group() : "fail";
            return new OCRForm(trackingnumber, phoneNumber, Name);

        }
        catch (TesseractException e) {
            e.printStackTrace();
            return new OCRForm("fail" ,"fail", "fail" );
        }
    }
}