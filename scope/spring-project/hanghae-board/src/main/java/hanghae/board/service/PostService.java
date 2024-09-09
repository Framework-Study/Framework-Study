package hanghae.board.service;

import hanghae.board.domain.dto.PostDto;
import hanghae.board.domain.mapper.PostMapper;
import hanghae.board.repository.PostRepository;
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
