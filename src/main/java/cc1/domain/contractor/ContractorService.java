package cc1.domain.contractor;

import cc1.domain.payment.PaymentService;
import cc1.domain.user.UserId;

public final class ContractorService {
    private final ContractorRepository contractorRepository;
    private final PaymentService paymentService;

    public ContractorService(ContractorRepository contractorRepository, PaymentService paymentService) {
        this.contractorRepository = contractorRepository;
        this.paymentService = paymentService;
    }

    public void validateContractor(UserId userId){
        if(this.checkIsContractorById(userId)){
            System.out.println("The user "+userId+" is already an official contractor.");
        }else{
            System.out.println("The user "+userId+" want to be an official contractor...");
            if(this.paymentService.checkUserPaymentById(userId)){
                this.contractorRepository.saveNewContractor(userId);
                System.out.println("The user "+userId+" is now an official contractor!");
            }else{
                throw new RuntimeException("The user "+userId+" have not effected payment so he cannot become a contractor.");
            }
        }
    }

    public boolean checkIsContractorById(UserId userId){
        return contractorRepository.byId(userId);
    }
}
