package hanghae.board.domain.user.service;


import hanghae.board.domain.user.dto.SignupRequestDto;
import hanghae.board.domain.user.entity.User;
import hanghae.board.domain.user.entity.UserRoleEnum;
import hanghae.board.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    // TODO : ADMIN_TOKEN 환경 변수로 값을 주입 받을 수 있도록 변경 필요
    private static final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입 관련 서비스 로직 작성
    @Transactional
    public boolean signup(SignupRequestDto signupRequestDto) {

        String loginId = signupRequestDto.getLoginId();
        String username = signupRequestDto.getUsername();
        String password = signupRequestDto.getPassword();

        // 중복 유저 확인
        Optional<User> found = userRepository.findByLoginId(loginId);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 아이디가 존재합니다.");
        }
        // 관리자 권한 확인
        UserRoleEnum role = UserRoleEnum.USER;
        if (signupRequestDto.isAdmin()) {
           if (!signupRequestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new IllegalArgumentException("관리자 암호가 틀려 등록이 불가능합니다.");
            }
            role = UserRoleEnum.ADMIN; // 관리자 권한 부여
        }
        userRepository.save(User.builder()
                .loginId(loginId)
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(role)
                .build());

        return true;
    }
}
