package hanghae.board.domain.post.mapper;

import hanghae.board.domain.post.dto.PostDto;
import hanghae.board.domain.post.entity.Post;
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
