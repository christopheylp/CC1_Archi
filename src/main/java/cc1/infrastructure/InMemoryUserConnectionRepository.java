package cc1.infrastructure;

import cc1.domain.connection.UserConnectionRepository;
import cc1.domain.user.UserId;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryUserConnectionRepository implements UserConnectionRepository {
    private final Map<UserId, Date> connections = new ConcurrentHashMap<>();

    @Override
    public void newUserConnectionById(UserId userid, Date date) {
        this.connections.put(userid,date);
    }

    @Override
    public void userDeconnectionById(UserId userid) {
        this.connections.remove(this.connections.remove(userid));
    }

    @Override
    public boolean userIsConnectedById(UserId userId) {
        return this.connections.containsKey(userId);
    }

    @Override
    public Map<UserId,Date> findAllConnectedUsersIds() {
        return connections;
    }
}
