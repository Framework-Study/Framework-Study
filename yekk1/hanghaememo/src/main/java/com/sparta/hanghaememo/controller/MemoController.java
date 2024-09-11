package com.sparta.hanghaememo.controller;

import com.sparta.hanghaememo.dto.MemoRequestDto;
import com.sparta.hanghaememo.entity.Memo;
import com.sparta.hanghaememo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {
    private final MemoService memoService;

    /**
     * 기본 화면
     * @return 화면 view&model 주소
     */
    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    /**
     * 메모 생성
     * @param requestDto 생성할 메모 정보
     * @return 생성된 메모
     */
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        return memoService.createMemo(requestDto);
    }

    /**
     * 메모 목록 조회
     * @return 전체조회 된 메모 목록
     */
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoService.getMemos();
    }

    /**
     * 메모 수정
     * @param id 수정할 메모 id
     * @param requestDto 수정할 메모 정보
     * @return 수정 된 메모 id
     */
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.update(id, requestDto);
    }

    /**
     * 메모 삭제
     * @param id 삭제할 메모 id
     * @return 삭제 된 메모 id
     */
    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id) {
        return memoService.deleteMemo(id);
    }
}
