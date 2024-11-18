package kr.co.bongdamsafety.onlinemap.repository;

import kr.co.bongdamsafety.onlinemap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 이 클래스가 Repository임을 나타냄
public interface UserRepository extends JpaRepository<User, Long> {
    // 이메일로 사용자 조회 메소드
    boolean existsByEmail(String email); // 이메일 중복 체크 메소드
    User findByEmail(String email); // 이메일로 사용자 조회 메소드
}
