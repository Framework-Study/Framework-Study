package hanghae.board.domain.post.service;

import hanghae.board.domain.post.dto.PostDto;
import hanghae.board.domain.post.mapper.PostMapper;
import hanghae.board.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;

    public List<PostDto> getAllPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream()
                .map(postMapper::toDto)
                .toList();
    }
}
