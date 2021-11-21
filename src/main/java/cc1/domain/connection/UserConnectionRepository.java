package cc1.domain.connection;

import cc1.domain.user.UserId;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public interface UserConnectionRepository {
    void newUserConnectionById(UserId userid, Date date);
    void userDeconnectionById(UserId userid);
    boolean userIsConnectedById(UserId userId);
    Map<UserId,Date> findAllConnectedUsersIds();
}
