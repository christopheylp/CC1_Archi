package cc1.domain.user;

import java.util.Objects;

public final class BankCard {
    private int number;
    private int code;

    public BankCard(int number, int code) {
        if (number<=9999 || code<=99) {
            throw new RuntimeException("The bank card number or code is not valid !");
        }
        this.number = number;
        this.code = code;
    }

    private static BankCard of(int number, int code){
        return new BankCard(number,code);
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "number=" + number +
                ", code=" + code +
                '}';
    }
}
