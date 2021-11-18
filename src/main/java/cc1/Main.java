package cc1;

import cc1.domain.UserConnectionService;
import cc1.domain.user.*;
import cc1.infrastructure.InMemoryUserRepository;

public final class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);
        final UserId myUserId = userRepository.nextIdentity();

        UserConnectionService connectionService = new UserConnectionService();

        validScenario( userService, myUserId,connectionService);
    }

    private static void validScenario(UserService userService, UserId userId,UserConnectionService connectionService) {
        createUser(userService, userId);
        changePassword(userService, userId);

        createUserConnection(userService,connectionService, userId);
        connectionService.checkConnection(userId);

        printUserById(userId, userService);
    }

    private static void createUser(UserService userService, UserId myUserId) {
        User user = User.of(myUserId, new EmailAddress("chris@gmail.com"), "chris", "yalap","pass");
        userService.create(user);
    }

    private static void changePassword(UserService userService, UserId myUserId) {
        userService.changePassword(myUserId, "new");
    }

    private static void printUserById(UserId userId, UserService userService){
        System.out.println(userService.byId(userId));
    }

    private static void createUserConnection(UserService userService, UserId userId) {
        UserConnectionService connectionService = new UserConnectionService();
        connectionService.connection(userService, userService.byId(userId).getEmailAddress(), userService.byId(userId).getPassword());
    }

    private static void createUserConnection(UserService userService,UserConnectionService connectionService, UserId userId) {
        connectionService.connection(userService, userService.byId(userId).getEmailAddress(), userService.byId(userId).getPassword());
    }

}
