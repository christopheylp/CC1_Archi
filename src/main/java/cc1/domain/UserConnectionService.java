package cc1.domain;

import cc1.domain.user.EmailAddress;
import cc1.domain.user.UserId;
import cc1.domain.user.UserService;

import java.util.ArrayList;

public final class UserConnectionService {
    private final ArrayList<UserId> connectedUsers;

    public UserConnectionService() {
        this.connectedUsers = new ArrayList<>();
    }

    public void connection(UserService userService, EmailAddress emailAddress, String password){
        connectedUsers.add(userService.byEmailAndPassword(emailAddress,password));
    }

    public void deconnection(UserId userId){
        connectedUsers.remove(userId);
    }

    public boolean checkConnection(UserId userId){
        return connectedUsers.contains(userId);
    }

}
