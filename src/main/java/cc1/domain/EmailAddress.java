package cc1.domain;

public final class EmailAddress {
    private final String email;

    private EmailAddress(String email) {
        if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            throw new RuntimeException("Email Address format not valid !");
        }
        this.email = email;
    }

    public static EmailAddress of(String email) {
        return new EmailAddress(email);
    }

    public String getValue() {
        return email;
    }
}
