package hanghae.board.domain.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class SignupRequestDto {
    @NotBlank
    @Size(min = 4, max = 10, message = "아이디는 4자 이상 10자 이하로 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "아이디는 영문 대소문자와 숫자로만 입력해주세요.")
    private String loginId;

    @NotBlank
    @Size(min = 4, max = 10, message = "유저명은 4자 이상 10자 이하로 입력해주세요.")
    private String username;

    @NotBlank
    @Size(min = 8, max = 15, message = "비밀번호는 8자 이상 15자 이하로 입력해주세요.")
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "비밀번호는 영문 대소문자와 숫자로만 입력해주세요.")
    private String password;

    private boolean admin = false;
    private String adminToken = "";
}
