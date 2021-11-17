package cc1.infrastructure;

import cc1.domain.article.Article;
import cc1.domain.article.ArticleId;
import cc1.domain.article.ArticleRepository;
import cc1.domain.user.User;
import cc1.domain.user.UserId;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryArticleRepository implements ArticleRepository {
    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<ArticleId, Article> data = new ConcurrentHashMap<>();

    @Override
    public void save(Article article) {
        data.put(article.getId(), article);
    }

    @Override
    public Article byId(ArticleId articleId) {
        final Article article = data.get(articleId);
        if (article == null) {
            throw new RuntimeException("No article for " + articleId.getValue());
        }
        return article;
    }

    @Override
    public ArticleId nextIdentity() {
        return ArticleId.of(counter.incrementAndGet());
    }

    @Override
    public List<Article> findAll() {
        return (List<Article>) data;
    }
}
