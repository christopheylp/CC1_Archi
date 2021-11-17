package cc1;

import cc1.domain.user.*;
import cc1.infrastructure.InMemoryUserRepository;
import java.util.Map;

public final class Main {

    public static void main(String[] args) {

        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);

        final UserId myUserId = userRepository.nextIdentity();

        createUser(userService, myUserId);
        changePassword(userService, myUserId);
        printAllUsers(userService);
    }

    private static void createUser(UserService userService, UserId myUserId) {
        User user = User.of(myUserId, new EmailAddress("chris@gmail.com"), "chris", "yalap","pass");
        userService.create(user);
    }

    private static void changePassword(UserService userService, UserId myUserId) {
        userService.changePassword(myUserId, "new");
    }

    private static void printAllUsers(UserService userService) {
        System.out.println("List all users");

        final Map<UserId, User> users = userService.all();
        for (Map.Entry<UserId, User> entry : users.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

}
