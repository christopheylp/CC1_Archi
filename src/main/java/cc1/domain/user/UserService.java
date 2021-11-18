package cc1.domain.user;

import java.util.Map;

public final class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        this.userRepository.save(user);
    }

    public void changePassword(UserId userId, String newPassword) {
        User user = this.userRepository.byId(userId);
        user.changePassword(newPassword);
        this.userRepository.save(user);
    }

    public Map<UserId, User> all() {
        return this.userRepository.findAll();
    }

    public User byId(UserId userId) {
        return this.userRepository.byId(userId);
    }

    public UserId byEmailAndPassword(EmailAddress email, String password) {
        return this.userRepository.byEmailAndPassword(email, password);
    }


}
