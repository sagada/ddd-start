package com.ddd.dddstart.article.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Table(name = "article")
@SecondaryTable(
        name = "article_content",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "article_id")
)
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "article_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "content", column = @Column(table = "article_content")),
            @AttributeOverride(name = "contentType", column = @Column(table = "article_content"))
    })
    private ArticleContent articleContent;

    public Article(String title, ArticleContent articleContent) {
        this.title = title;
        this.articleContent = articleContent;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public ArticleContent getArticleContent() {
        return articleContent;
    }
}
