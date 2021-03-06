package cc1.domain.contractor;

import cc1.domain.user.UserId;

import java.util.ArrayList;

public interface ContractorRepository  {
    boolean saveNewContractor(UserId userid);

    boolean byId(UserId userId);

    ArrayList<UserId> findAllContractorsIds();
}
