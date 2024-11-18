package kr.co.bongdamsafety.onlinemap.api;

import kr.co.bongdamsafety.onlinemap.dto.UserDto;
import kr.co.bongdamsafety.onlinemap.entity.User;
import kr.co.bongdamsafety.onlinemap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // RESTful 웹 서비스 컨트롤러를 나타냄
@RequestMapping("/api/users") // "/api/users" 경로에 대한 요청을 처리
@CrossOrigin(origins = "http://localhost:3000/login")
public class UserRestController {
    private final UserService userService; // UserService를 주입받아 사용

    // 생성자: UserService를 주입받아 초기화합니다.
    @Autowired // 자동 주입을 위한 애너테이션
    public UserRestController(UserService userService) {
        this.userService = userService; // 주입된 UserService를 필드에 저장
    }

    // POST 요청: 사용자 등록을 처리하는 메소드입니다.
    @PostMapping("/register") // "/api/users/register" 경로에 대한 POST 요청을 처리
    public ResponseEntity<String> registerUser(@ModelAttribute UserDto userDto) {
        try {
            // 사용자 등록 서비스 호출
            this.userService.registerUser(userDto); // 이메일 사용
            // 사용자 등록 성공 시 201 CREATED 응답 반환
            return new ResponseEntity<>("가입에 성공하였습니다.", HttpStatus.CREATED);
        } catch (Exception e) {
            // 사용자 등록 실패 시 400 BAD REQUEST 응답 반환
            return new ResponseEntity<>("가입에 실패하였습니다.", HttpStatus.BAD_REQUEST);
        }
    }

    // POST 요청: 사용자 로그인을 처리하는 메소드입니다.
    @PostMapping("/login") // "/api/users/login" 경로에 대한 POST 요청을 처리
    public ResponseEntity<String> loginUser(@ModelAttribute UserDto userDto) {
        // 사용자 로그인 서비스 호출
        User user = this.userService.loginUser(userDto.getEmail(), userDto.getPassword()); // 이메일 사용
        // 로그인 성공 시 200 OK 응답, 실패 시 401 UNAUTHORIZED 응답 반환
        return user != null
                ? new ResponseEntity<>("로그인 성공", HttpStatus.OK)
                : new ResponseEntity<>("이메일 또는 비밀번호가 틀렸습니다.", HttpStatus.UNAUTHORIZED); // 메시지 수정
    }
}