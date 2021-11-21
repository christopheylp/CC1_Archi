package cc1.domain.payment;

import cc1.domain.connection.UserConnectionRepository;
import cc1.domain.user.BankCard;
import cc1.domain.user.UserId;
import cc1.domain.user.UserService;

public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final UserConnectionRepository userConnectionRepository;


    public PaymentService(PaymentRepository paymentRepository, UserConnectionRepository userConnectionRepository) {
        this.paymentRepository = paymentRepository;
        this.userConnectionRepository = userConnectionRepository;
    }

    public boolean makeUserPayment(UserService userService, UserId userId){
        if(!this.userConnectionRepository.userIsConnectedById(userId)){
            throw new RuntimeException("The user "+userId+" is not connected.");
        }
        System.out.println("The user "+userId+" want to make a payment!");
        BankCard userBankCard = userService.byId(userId).getBankCardChoice();
        if( userBankCard == null){
            throw new RuntimeException("The BankCard of the user "+userId+" is not valid");
        }
        System.out.println("The user "+userId+" has now paid with the bank card: "+userBankCard);
        return this.paymentRepository.savePayer(userId);
    }

    public boolean checkUserPaymentById(UserId userId){
        return paymentRepository.payerById(userId);
    }

}
