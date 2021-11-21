package cc1.domain.user;

import java.util.regex.Pattern;

public final class EmailAddress {
    private final String email;

    public EmailAddress(String email) {
        Pattern pattern = Pattern.compile("^(.+)@(\\S+)$");
        if (!pattern.matcher(email).matches()) {
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
