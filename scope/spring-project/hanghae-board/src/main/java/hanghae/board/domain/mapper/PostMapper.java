package hanghae.board.domain.mapper;

import hanghae.board.domain.dto.PostDto;
import hanghae.board.domain.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    public PostDto toDto(Post post) {
        return new PostDto(
                post.getPostId(),
                post.getTitle(),
                post.getDescription(),
                post.getMainImageUrl(),
                post.getVideoUrl(),
                post.getServing(),
                post.getCookTime(),
                post.getServing(),
                post.getDifficulty(),
                post.getTip(),
                post.getCreatedAt(),
                post.getUpdatedAt()
        );
    }
}
