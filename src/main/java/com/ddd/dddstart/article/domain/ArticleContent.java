package com.ddd.dddstart.article.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class ArticleContent {
    private String content;
    private String contentType;

    protected ArticleContent()
    {
    }

    public ArticleContent(String content, String contentType)
    {
        this.content = content;
        this.contentType = contentType;
    }
}
