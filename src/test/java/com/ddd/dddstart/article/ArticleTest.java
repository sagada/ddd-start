package com.ddd.dddstart.article;

import com.ddd.dddstart.article.domain.Article;
import com.ddd.dddstart.article.domain.ArticleContent;
import com.ddd.dddstart.article.domain.ArticleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;

@SpringBootTest
public class ArticleTest {

    @Autowired
    ArticleRepository articleRepository;

    @Test
    @Commit
    public void test1()
    {
        Article article = new Article("title1", new ArticleContent("content", "매일우유"));
        Article save = articleRepository.save(article);

        Assertions.assertEquals(save.getArticleContent().getContent(), "content");
    }
}
