package cc1.infrastructure;

import cc1.domain.contractuor.ContractorRepository;
import cc1.domain.payment.PaymentRepository;
import cc1.domain.user.UserId;

import java.util.ArrayList;

public final class InMemoryPaymentRepository implements PaymentRepository {
    private final ArrayList<UserId> usersIdsHavingPaid = new ArrayList<>();

    @Override
    public boolean savePayer(UserId userId) {
        return this.usersIdsHavingPaid.add(userId);
    }

    @Override
    public boolean payerById(UserId userId) {
        return this.usersIdsHavingPaid.contains(userId);
    }

    @Override
    public ArrayList<UserId> findAllPayers() {
        return this.usersIdsHavingPaid;
    }
}
