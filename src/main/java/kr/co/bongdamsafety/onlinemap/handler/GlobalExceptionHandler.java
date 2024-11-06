package kr.co.bongdamsafety.onlinemap.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(MaxUploadSizeExceededException exc, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("파일용량 초과", "파일의 용량이 너무 큽니다. 각 파일은 10MB, 모든 파일은 합쳐서 20MB까지 업로드 가능합니다.");
        return "redirect:/";
    }
}