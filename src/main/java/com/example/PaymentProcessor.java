package com.kleber.payments;

import java.util.List;
import java.util.function.Consumer;

public class PaymentProcessor {
    public static void main(String[] args) {
        List<Payment> payments = List.of(
                new CreditCardPayment(150.0),
                new PixPayment(75.5)
        );

        // Lambda para processar os pagamentos
        Consumer<Payment> process = Payment::process;

        payments.forEach(process);
    }
}
