package org.recipe.api.service;

import lombok.RequiredArgsConstructor;
import org.recipe.api.service.dto.CreateBoardDto;
import org.recipe.domain.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 게시판 서비스
 */
@Service
@RequiredArgsConstructor
@Transactional
public class BoardService {
    private BoardRepository boardRepository;
    /**
     * 게시글 등록
     * @param dto       게시글 정보
     * @param nickname  작성자 닉네임
     * @return
     */
    public Long createBoard(CreateBoardDto dto, String nickname) {
        CreateBoardDto dto1 = new CreateBoardDto("title", "subtitle", 1, 1, 1, "tip");
//        boardRepository.save(dto1);
        return null;
    }
}
