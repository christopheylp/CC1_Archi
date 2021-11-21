package cc1.infrastructure;

import cc1.domain.contractuor.ContractorRepository;
import cc1.domain.user.UserId;

import java.util.ArrayList;

public final class InMemoryContractorRepository implements ContractorRepository {
    private final ArrayList<UserId> contractors = new ArrayList<>();

    @Override
    public boolean saveNewContractor(UserId userId) {
        return this.contractors.add(userId);
    }

    @Override
    public boolean byId(UserId userId) {
        return this.contractors.contains(userId);
    }

    @Override
    public ArrayList<UserId> findAllContractorsIds() {
        return this.contractors;
    }
}
