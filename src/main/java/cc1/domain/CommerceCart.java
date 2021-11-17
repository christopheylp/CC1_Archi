package cc1.domain;

import cc1.domain.article.Article;
import cc1.domain.user.UserId;

import java.util.List;

public class CommerceCart {
    private UserId userId;
    private List<Article> articles;


    public CommerceCart(UserId userId, List<Article> articles) {
        this.userId = userId;
        this.articles = articles;
    }

    public static CommerceCart of(UserId userId, List<Article> articles) {
        return new CommerceCart(userId, articles);
    }

    public void addArticle(Article article){
        this.articles.add(article);
    }

    @Override
    public String toString() {
        return "CommerCart{" +
                "userId=" + userId +
                ", articles='" + articles + '\'' +
                '}';
    }
}
