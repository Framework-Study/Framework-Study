package hanghae.board.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class SignupRequestDto {
    private String loginId;
    private String username;
    private String password;
    private boolean admin = false;
    private String adminToken = "";
}
