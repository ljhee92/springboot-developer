package me.juhee.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.juhee.springbootdeveloper.domain.Article;
import me.juhee.springbootdeveloper.dto.AddArticleRequest;
import me.juhee.springbootdeveloper.dto.UpdateArticleRequest;
import me.juhee.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request, String userName) {
        return blogRepository.save(request.toEntity(userName));
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest updateArticleRequest) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        article.update(updateArticleRequest.getTitle(), updateArticleRequest.getContent());

        return article;
    }
}
