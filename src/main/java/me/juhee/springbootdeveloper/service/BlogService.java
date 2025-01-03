package me.juhee.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.juhee.springbootdeveloper.domain.Article;
import me.juhee.springbootdeveloper.dto.AddArticleRequest;
import me.juhee.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}
