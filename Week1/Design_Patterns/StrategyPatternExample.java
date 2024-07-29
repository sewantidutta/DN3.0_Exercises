    /*
    Exercise 8: Implementing the Strategy Pattern
    Scenario: 
    You are developing a payment system where different payment methods (e.g., Credit Card, PayPal) can be selected at runtime. Use the Strategy Pattern to achieve this.
    Steps:
    1.	Create a New Java Project:
    o	Create a new Java project named StrategyPatternExample.
    2.	Define Strategy Interface:
    o	Create an interface PaymentStrategy with a method pay().
    3.	Implement Concrete Strategies:
    o	Create classes CreditCardPayment, PayPalPayment that implement PaymentStrategy.
    4.	Implement Context Class:
    o	Create a class PaymentContext that holds a reference to PaymentStrategy and a method to execute the strategy.
    5.	Test the Strategy Implementation:
    o	Create a test class to demonstrate selecting and using different payment strategies.
    */

    // PaymentStrategy.java
    interface PaymentStrategy {
        void pay(double amount);
    }

    // CreditCardPayment.java
    class CreditCardPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paying $" + amount + " using Credit Card");
        }
    }

    // PayPalPayment.java
    class PayPalPayment implements PaymentStrategy {
        @Override
        public void pay(double amount) {
            System.out.println("Paying $" + amount + " using PayPal");
        }
    }

    // PaymentContext.java
    class PaymentContext {
        private PaymentStrategy pStrategy;

        public PaymentContext(PaymentStrategy pStrategy) {
            this.pStrategy = pStrategy;
        }

        public void setPaymentStrategy(PaymentStrategy pStrategy) {
            this.pStrategy = pStrategy;
        }

        public void executePayment(double amount) {
            pStrategy.pay(amount);
        }
    }
    public class StrategyPatternExample {
        public static void main(String[] args) {
            PaymentContext paymentContext = new PaymentContext(new CreditCardPayment());
            paymentContext.executePayment(100.0);

            paymentContext.setPaymentStrategy(new PayPalPayment());
            paymentContext.executePayment(200.0);
        }
    }
