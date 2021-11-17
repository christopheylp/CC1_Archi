package cc1.domain;

import java.util.Objects;

public final class User {
    private final UserId userId;
    private final EmailAddress emailAddress;
    private final String lastname;
    private final String firstname;
    private String password;

    public User(UserId userId, EmailAddress emailAddress, String lastname, String firstname, String password) {
        this.userId = Objects.requireNonNull(userId);
        this.emailAddress = Objects.requireNonNull(emailAddress);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.password = Objects.requireNonNull(password);
    }

    public static User of(UserId userId, EmailAddress emailAddress, String lastname, String firstname, String password) {
        return new User(userId, emailAddress, lastname, firstname, password);
    }

    public UserId getUserId() {
        return userId;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
