package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.service.RootPageHelloWorldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RootPageHelloWorldApiController {
    @Autowired
    private RootPageHelloWorldService rootPageHelloWorldService;

    // GET
    @GetMapping("/") // 루트 페이지
    public String index() {
        // 루트 페이지에 접속하면 "Hello world!" 출력
        return rootPageHelloWorldService.helloWorld();
    }
}
