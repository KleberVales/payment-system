package com.kleber.payments;

public sealed abstract class Payment permits CreditCardPayment, PixPayment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void process();
}
