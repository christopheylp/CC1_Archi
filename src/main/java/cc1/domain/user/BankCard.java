package cc1.domain.user;

public final class BankCard {
    private int number;
    private int code;

    public BankCard(int number, int code) {
        this.number = number;
        this.code = code;
    }

    private static BankCard of(int number, int code){
        return new BankCard(number,code);
    }
}
