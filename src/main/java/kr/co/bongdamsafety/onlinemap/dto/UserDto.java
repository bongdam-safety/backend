package kr.co.bongdamsafety.onlinemap.dto;

import kr.co.bongdamsafety.onlinemap.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class UserDto {
    private PasswordEncoder passwordEncoder;

    private Long id; // 사용자 ID
    private String email; // 사용자 이메일 필드
    private String password; // 비밀번호 필드
    private String encodedPassword = this.passwordEncoder.encode(password); // 암호화된 비밀번호
    private String name; // 성명
    private String content; // 계정 설명
    private Timestamp date_created; // 계정 생성일


    public User toEntity() {
        return new User(id, email, encodedPassword, name, content, null);
    }

}