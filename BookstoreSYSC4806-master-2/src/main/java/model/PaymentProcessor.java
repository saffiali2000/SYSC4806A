package model;

import entity.Book;
import entity.Cart;
import entity.Customer;

/**
 * Instances of PaymentProcessor are responsible for processing transactions of items in shopping cart.
 */
public class PaymentProcessor {

    /**
     * Counter for generating unique transaction numbers.
     */
    private static int transactionCounter = 10000;

    /**
     * Processes the payment for the given shopping cart.
     *
     * @param cart     The shopping cart to process.
     * @param customer The customer paying.
     */
    public static void processPayment(Customer customer, Cart cart) {
        // Check if the cart is null or empty
        if (cart == null || cart.getItems().isEmpty()) {
            System.out.println("PAYMENT CANNOT BE PROCESSED: SHOPPING CART IS EMPTY!");
            return;
        }

        // Generate a unique transaction number
        int transactionNumber = generateTransactionNumber();
        // Calculate the total amount for the items in the cart
        double totalAmount = cart.calculateTotal();

        System.out.println("*******************************************************");
        System.out.println("Transaction #: " + transactionNumber);
        System.out.println("\nProcessing payment of $" + totalAmount + "...\n");

        // Display the contents of the cart
        printCartContents(cart);

        System.out.println("***** PAYMENT APPROVED *****");
        updateCustomerPurchaseHistory(customer, cart);
        cart.clearCart();

        System.out.println("*******************************************************");
    }

    private static void updateCustomerPurchaseHistory(Customer customer, Cart cart) {
        for (Book book : cart.getItems()) {
            // Update the quantity of each book in the inventory
            customer.addToPurchaseHistory(book);
        }
    }

    /**
     * Generates a unique transaction number.
     *
     * @return The generated transaction number.
     */
    public static int generateTransactionNumber() {
        return transactionCounter++;
    }

    /**
     * Displays the contents of the shopping cart.
     *
     * @param cart The shopping cart to display.
     */
    private static void printCartContents(Cart cart) {
        System.out.println(cart.toString());
    }
}
