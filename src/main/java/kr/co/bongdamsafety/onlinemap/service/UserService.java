package kr.co.bongdamsafety.onlinemap.service;

import kr.co.bongdamsafety.onlinemap.dto.UserDto;
import kr.co.bongdamsafety.onlinemap.entity.User;
import kr.co.bongdamsafety.onlinemap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service // 이 클래스가 서비스 계층의 컴포넌트임을 나타냄
public class UserService {
    private final UserRepository userRepository; // 사용자 정보를 데이터베이스에 저장하고 조회하는 레포지토리
    private final PasswordEncoder passwordEncoder; // 비밀번호를 암호화하는 데 사용하는 인코더

    // 생성자: UserRepository와 PasswordEncoder를 주입받아 초기화
    @Autowired // 자동 주입을 위한 애너테이션
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository; // 주입받은 UserRepository를 필드에 저장
        this.passwordEncoder = passwordEncoder; // 주입받은 PasswordEncoder를 필드에 저장
    }

    // 사용자 등록 메소드
    public void registerUser(UserDto dto) { // username 대신 email 사용
        User user = dto.toEntity(); // UserDto 객체를 User 객체로 변환
        this.userRepository.save(user); // User 객체를 데이터베이스에 저장
    }

    // 사용자 로그인 메소드
    public User loginUser(String email, String password) { // username 대신 email 사용
        // 이메일로 사용자 조회
        User user = this.userRepository.findByEmail(email); // findByEmail 메소드를 사용하여 사용자 조회
        // 사용자 존재 여부와 비밀번호 일치 여부를 확인
        return user != null && this.passwordEncoder.matches(password, user.getPassword()) ? user : null;
        // 사용자 정보가 존재하고 비밀번호가 일치하면 User 객체를 반환, 그렇지 않으면 null 반환
    }
}