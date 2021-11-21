package cc1.domain.payment;

import cc1.domain.user.UserId;

import java.util.ArrayList;

public interface PaymentRepository {
    boolean savePayer(UserId userid);

    boolean payerById(UserId userId);

    ArrayList<UserId> findAllPayers();
}

