package me.juhee.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.juhee.springbootdeveloper.domain.Article;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddArticleRequest {
    private String author;
    private String title;
    private String content;

    public Article toEntity() {
        return Article.builder()
                .author(author)
                .title(title)
                .content(content)
                .build();
    }
}
