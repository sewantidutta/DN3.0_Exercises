/*Exercise 4: Implementing the Adapter Pattern
Scenario: 
You are developing a payment processing system that needs to integrate with multiple third-party payment gateways with different interfaces. Use the Adapter Pattern to achieve this.
Steps:
1.	Create a New Java Project:
o	Create a new Java project named AdapterPatternExample.
2.	Define Target Interface:
o	Create an interface PaymentProcessor with methods like processPayment().
3.	Implement Adaptee Classes:
o	Create classes for different payment gateways with their own methods.
4.	Implement the Adapter Class:
o	Create an adapter class for each payment gateway that implements PaymentProcessor and translates the calls to the gateway-specific methods.
5.	Test the Adapter Implementation:
o	Create a test class to demonstrate the use of different payment gateways through the adapter.
*/// PaymentProcessor.java


interface PaymentProcessor {
    void processPayment(String paymentDetails);
}

// PayPal.java
class PayPal {
    public void makePayment(String paymentDetails) {
        System.out.println("Processing payment through PayPal: " + paymentDetails);
    }
}

// PhonePe.java
class PhonePe{
    public void payVia(String paymentDetails) {
        System.out.println("Processing payment through Stripe: " + paymentDetails);
    }
}

// PayPalAdapter.java
class PayPalAdapter implements PaymentProcessor {
    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(String paymentDetails) {
        paypal.makePayment(paymentDetails);
    }
}

// StripeAdapter.java
class PhonePeAdapter implements PaymentProcessor {
    private PhonePe phonepe;

    public PhonePeAdapter(PhonePe phonepe) {
        this.phonepe = phonepe;
    }

    @Override
    public void processPayment(String paymentDetails) {
        phonepe.payVia(paymentDetails);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        // Create instances of payment gateways
        PayPal paypal = new PayPal();
        PhonePe phonepe = new PhonePe();

        // Create adapters for payment gateways
        PaymentProcessor paypalAdapter = new PayPalAdapter(paypal);
        PaymentProcessor phonepeAdapter = new PhonePeAdapter(phonepe);

        // Process payments through adapters
        paypalAdapter.processPayment("Payment details for PayPal");
        phonepeAdapter.processPayment("Payment details for PhonePe");
    }
}
  