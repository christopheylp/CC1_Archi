package cc1.domain.article;



import java.util.List;

public interface ArticleRepository {
    void save(Article article);

    Article byId(ArticleId articleId);

    ArticleId nextIdentity();

    List<Article> findAll();
}
