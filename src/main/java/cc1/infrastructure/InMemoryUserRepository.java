package cc1.infrastructure;

import cc1.domain.user.EmailAddress;
import cc1.domain.user.User;
import cc1.domain.user.UserId;
import cc1.domain.user.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class InMemoryUserRepository implements UserRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private final Map<UserId, User> data = new ConcurrentHashMap<>();

    @Override
    public void save(User user) {
        data.put(user.getId(), user);
    }

    @Override
    public User byId(UserId userId) {
        final User user = data.get(userId);
        if (user == null) {
            throw new RuntimeException("No user for " + userId.getValue());
        }
        return user;
    }

    @Override
    public UserId byEmailAndPassword(EmailAddress email, String password) {
        for (Map.Entry<UserId, User> user : data.entrySet()) {
            if(user.getValue().getEmailAddress() == email && user.getValue().getPassword().equals(password)){
                return user.getKey();
            }
        }
        throw new RuntimeException("These identifies are incorrect!");
    }

    @Override
    public UserId nextIdentity() {
        return UserId.of(counter.incrementAndGet());
    }

    @Override
    public Map<UserId, User> findAll() {
        return data;
    }

}
