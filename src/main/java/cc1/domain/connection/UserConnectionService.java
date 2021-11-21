package cc1.domain.connection;

import cc1.domain.user.EmailAddress;
import cc1.domain.user.UserId;
import cc1.domain.user.UserService;

import java.util.Date;

public final class UserConnectionService {
    private final UserConnectionRepository userConnectionRepository;

    public UserConnectionService(UserConnectionRepository userConnectionRepository) {
        this.userConnectionRepository = userConnectionRepository;
    }

    public final void connection(UserService userService, EmailAddress emailAddress, String password){
        UserId userId = userService.userIdByEmailAndPassword(emailAddress,password);
        if(this.userConnectionRepository.userIsConnectedById(userId)){
            System.out.println("The user "+userId+" is already connected!");
        }else{
            userConnectionRepository.newUserConnectionById(userId, new Date());
            System.out.println("The user "+userId+" is now connected!");
        }
    }

    public final void deconnection(UserId userId){
        if(!this.userConnectionRepository.userIsConnectedById(userId)){
            System.out.println("The user "+userId+" is already deconnected!");
        }else{
            userConnectionRepository.userDeconnectionById(userId);
            System.out.println("The user "+userId+" is now deconnected!");
        }
    }

    public boolean checkConnection(UserId userId){
        return userConnectionRepository.userIsConnectedById(userId);
    }

}
