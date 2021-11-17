package cc1.domain.user;

import java.util.Objects;

public final class User {
    private final UserId id;
    private final EmailAddress emailAddress;
    private final String lastname;
    private final String firstname;
    private String password;

    public User(UserId id, EmailAddress emailAddress, String lastname, String firstname, String password) {
        this.id = Objects.requireNonNull(id);
        this.emailAddress = Objects.requireNonNull(emailAddress);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.password = Objects.requireNonNull(password);
    }

    public static User of(UserId userId, EmailAddress emailAddress, String lastname, String firstname, String password) {
        return new User(userId, emailAddress, lastname, firstname, password);
    }

    public UserId getId() {
        return this.id;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
