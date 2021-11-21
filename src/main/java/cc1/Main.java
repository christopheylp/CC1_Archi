package cc1;

import cc1.domain.connection.UserConnectionRepository;
import cc1.domain.connection.UserConnectionService;
import cc1.domain.contractor.ContractorRepository;
import cc1.domain.contractor.ContractorService;
import cc1.domain.payment.PaymentRepository;
import cc1.domain.payment.PaymentService;
import cc1.domain.user.*;
import cc1.infrastructure.InMemoryUserConnectionRepository;
import cc1.infrastructure.InMemoryContractorRepository;
import cc1.infrastructure.InMemoryPaymentRepository;
import cc1.infrastructure.InMemoryUserRepository;

public final class Main {

    public static void main(String[] args) {
        UserRepository userRepository = new InMemoryUserRepository();
        UserService userService = new UserService(userRepository);
        final UserId userId = userRepository.nextIdentity();

        UserConnectionRepository userConnectionRepository = new InMemoryUserConnectionRepository();
        UserConnectionService userConnectionService = new UserConnectionService(userConnectionRepository);

        PaymentRepository paymentRepository = new InMemoryPaymentRepository();
        PaymentService paymentService = new PaymentService(paymentRepository, userConnectionRepository);

        ContractorRepository contractorRepository = new InMemoryContractorRepository();
        ContractorService contractorService = new ContractorService(contractorRepository,paymentService);

        createValidUser(userService, userId);
        changePassword(userService, userId);

        createUserConnection(userService,userConnectionService, userId);
        createUserConnection(userService,userConnectionService, userId);

        processPayment(paymentService, userService, userId);
        userToContractor(contractorService,userId);

        createUserDeconnection(userConnectionService,userId);
    }

    private static void userToContractor(ContractorService contractorService, UserId userId) {
        contractorService.validateContractor(userId);
    }

    private static void processPayment(PaymentService paymentService, UserService userService, UserId userId) {
        paymentService.makeUserPayment(userService, userId);
    }

    private static void createValidUser(UserService userService, UserId myUserId) {
        BankCard bankCard = new BankCard(12345,111);
        User user = User.of(myUserId, new EmailAddress("chris@gmail.com"), "chris", "yalap","pass", bankCard);
        userService.create(user);
    }

    private static void changePassword(UserService userService, UserId myUserId) {
        userService.changePassword(myUserId, "new");
    }

    private static void createUserConnection(UserService userService,UserConnectionService connectionService, UserId userId) {
        connectionService.connection(userService, userService.byId(userId).getEmailAddress(), "new");
    }

    private static void createUserDeconnection(UserConnectionService userConnectionService,UserId userId) {
        userConnectionService.deconnection(userId);
    }

}
