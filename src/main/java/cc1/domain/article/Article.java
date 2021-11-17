package cc1.domain.article;

import java.util.Objects;

public class Article {
    private final ArticleId id;
    private String name;
    private int price;

    public Article(ArticleId id, int price, String name) {
        this.id = Objects.requireNonNull(id);
        this.price = Objects.requireNonNull(price);
        this.name = Objects.requireNonNull(name);
    }

    public static Article of(ArticleId id, int cost, String name) {
        return new Article( id, cost, name);
    }

    public void changeCost(int newPrice) {
        this.price = Objects.requireNonNull(newPrice);
    }

    public ArticleId getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}
