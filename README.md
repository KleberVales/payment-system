# Payment System 💳

A simple Java payment system created to demonstrate **object-oriented programming, polymorphism, sealed classes, interfaces, and functional programming**.

The project models different payment methods through a common `Payment` abstraction and demonstrates how different payment implementations can be processed using polymorphism and Java functional interfaces.

## 🎯 Purpose

The main goal of this project is to practice and demonstrate modern Java concepts through a simple payment-processing domain.

The project explores:

- Object-oriented programming
- Abstraction
- Inheritance
- Polymorphism
- Interfaces
- Sealed classes
- `final` classes
- Method overriding
- Functional interfaces
- Lambda expressions
- Method references
- Collections
- `Consumer<T>`

## 🏗️ Project Structure

```text
payment-system/
└── src/
    └── main/
        └── java/
            └── com/
                └── kleber/
                    └── payments/
                        ├── CreditCardPayment.java
                        ├── Payment.java
                        ├── PaymentMethod.java
                        ├── PaymentProcessor.java
                        ├── PaymentType.java
                        └── PixPayment.java
```

## 🧩 Architecture

The core of the project is the `Payment` abstraction.

```text
                    Payment
                       │
              ┌────────┴────────┐
              │                 │
      CreditCardPayment     PixPayment
              │                 │
              └────────┬────────┘
                       │
                PaymentProcessor
```

`Payment` is declared as a **sealed class**, explicitly restricting which classes can extend it. The current implementations are `CreditCardPayment` and `PixPayment`.

```java
public sealed abstract class Payment
        permits CreditCardPayment, PixPayment {
    
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract void process();
}
```

This provides a controlled inheritance hierarchy while still allowing polymorphic processing.

## 💳 Supported Payment Types

### Credit Card

`CreditCardPayment` represents a credit-card payment implementation.

### PIX

`PixPayment` represents a PIX payment implementation and overrides the `process()` method to provide its own payment-processing behavior.

```java
public final class PixPayment extends Payment {

    public PixPayment(double amount) {
        super(amount);
    }

    @Override
    public void process() {
        System.out.println("Processing PIX payment of $" + amount);
    }
}
```

## ⚙️ Payment Processing

The `PaymentProcessor` class creates different payment implementations and stores them in a collection of the common `Payment` type.

```java
List<Payment> payments = List.of(
    new CreditCardPayment(150.0),
    new PixPayment(75.5)
);
```

The payments are then processed using a `Consumer<Payment>` and a method reference:

```java
Consumer<Payment> process = Payment::process;

payments.forEach(process);
```

This demonstrates how Java's functional programming features can be combined with polymorphism.

## 🧠 Java Concepts Demonstrated

### Sealed Classes

The `Payment` class uses a sealed hierarchy:

```java
public sealed abstract class Payment
        permits CreditCardPayment, PixPayment
```

This explicitly defines which classes are allowed to extend `Payment`.

### Polymorphism

Different payment implementations can be handled through the same `Payment` reference:

```java
List<Payment> payments = List.of(
    new CreditCardPayment(150.0),
    new PixPayment(75.5)
);
```

Each implementation provides its own version of `process()`.

### Method Reference

The project uses:

```java
Payment::process
```



