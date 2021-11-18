package cc1.domain.user;

import java.util.List;
import java.util.Map;

public interface UserRepository {
    void save(User user);

    User byId(UserId userId);

    UserId byEmailAndPassword(EmailAddress email, String password);

    UserId nextIdentity();

    Map<UserId, User> findAll();
}
