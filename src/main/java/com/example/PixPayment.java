package com.kleber.payments;

public final class PixPayment extends Payment {
    public PixPayment(double amount) {
        super(amount);
    }

    @Override
    public void process() {
        System.out.println("Processing PIX payment of $" + amount);
    }
}
