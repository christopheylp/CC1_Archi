package cc1.domain.user;

import java.util.ArrayList;
import java.util.Objects;

public final class User {
    private final UserId id;
    private final EmailAddress emailAddress;
    private final String lastname;
    private final String firstname;
    private String password;
    private ArrayList<BankCard> bankCards = new ArrayList<>();

    public User(UserId id, EmailAddress emailAddress, String lastname, String firstname, String password, BankCard bankCard) {
        this.id = Objects.requireNonNull(id);
        this.emailAddress = Objects.requireNonNull(emailAddress);
        this.lastname = Objects.requireNonNull(lastname);
        this.firstname = Objects.requireNonNull(firstname);
        this.password = Objects.requireNonNull(password);
        this.bankCards.add(Objects.requireNonNull(bankCard));
    }

    public static User of(UserId userId, EmailAddress emailAddress, String lastname, String firstname, String password, BankCard bankCard) {
        return new User(userId, emailAddress, lastname, firstname, password, bankCard);
    }

    public UserId getId() {
        return this.id;
    }

    public void changePassword(String newPassword) {
        this.password = Objects.requireNonNull(newPassword);
    }

    public EmailAddress getEmailAddress() {
        return this.emailAddress;
    }

    public String getPassword() {
        return this.password;
    }

    public ArrayList<BankCard> getCardsBank() {
        return this.bankCards;
    }

    public BankCard getBankCardChoice(){
        if(this.bankCards.size() != 0){
            return this.getCardsBank().get(0);
        }else{
            throw new RuntimeException("The user have not registered bank card!");
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", emailAddress=" + emailAddress +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", password='" + password + '\'' +
                ", bankCard=" + bankCards +
                '}';
    }
}
