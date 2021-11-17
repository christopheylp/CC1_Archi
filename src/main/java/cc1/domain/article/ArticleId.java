package cc1.domain.article;

public class ArticleId {
    private final int value;

    private ArticleId(int value) {
        this.value = value;
    }

    public static ArticleId of(int value) {
        return new ArticleId(value);
    }

    public String getValue() {
        return String.valueOf(value);
    }
}
