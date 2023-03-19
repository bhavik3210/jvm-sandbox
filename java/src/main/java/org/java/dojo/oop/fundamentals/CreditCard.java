package org.java.dojo.oop.fundamentals;

import java.util.Optional;
import java.util.UUID;

public class CreditCard {
    private final long creditCardNumber;

    CreditCard(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    Optional<Payment> makePayment(int amount) {
        if (Math.random() > 0.3) {
            return Optional.of(new Payment(this, amount, UUID.randomUUID()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditCardNumber=" + creditCardNumber +
                '}';
    }
}
