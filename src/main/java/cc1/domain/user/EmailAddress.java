package cc1.domain.user;

public final class EmailAddress {
    private final String email;

    public EmailAddress(String email) {
        if (email.matches("^[\\\\w!#$%&’*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$")) {
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
