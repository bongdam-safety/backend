package kr.co.bongdamsafety.onlinemap.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RootPageHelloWorldApiController {
    // GET
    @GetMapping("/")
    public String index() {
        return "Hello world!";
    }
}
