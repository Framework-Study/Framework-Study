package hanghae.board.domain.post.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PostDto(
        Long postId,
        String title,
        String description,
        String mainImageUrl,
        String videoUrl,
        int view,
        int serving,
        int cookTime,
        BigDecimal difficulty,
        String tip,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
){};
