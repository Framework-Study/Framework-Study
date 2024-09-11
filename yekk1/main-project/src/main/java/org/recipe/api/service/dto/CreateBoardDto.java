package org.recipe.api.service.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 게시글 생성 DTO
 */
@Data
@NoArgsConstructor
public class CreateBoardDto {
    private String title;
    private String subtitle;
    private Integer serving;
    private Integer cooking_time;
    private Integer cooking_level;
    private String tip;

    @Builder

    public CreateBoardDto(String title, String subtitle, Integer serving, Integer cooking_time, Integer cooking_level, String tip) {
        this.title = title;
        this.subtitle = subtitle;
        this.serving = serving;
        this.cooking_time = cooking_time;
        this.cooking_level = cooking_level;
        this.tip = tip;
    }
}
