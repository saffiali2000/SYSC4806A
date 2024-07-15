package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * JUnit test class for the PaymentProcessor class.
 *
 * @author Mahtab Ameli
 */
public class PaymentProcessorTest {

    // Creates ByteArrayOutputStream for testing System.out content
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    // Stores the original System.out so that it can be restored after testing
    private final PrintStream originalOut = System.out;

    /**
     * Sets up capturing System.Out output.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Tests the processPayment method for a successful payment.
     */
/*    @Test
    public void testProcessPaymentSuccessful() {
        // Set up Book, Cart, and Customer for testing
        BookStoreManagement bookStoreManagement = new BookStoreManagement();
        Book book = new Book(123, "Book 1", "Author 1", "Publisher 1", 10, 30);
        bookStoreManagement.addBook(book);

        Cart cart = new Cart();
        cart.addBook(book, 2);
        Customer customer = new Customer("customer@example.com", "1234567890", "customer1", "password", 1, "Mahtab Ameli", "333 University Way");
        customer.setCart(cart);

        // Call processPayment method
        PaymentProcessor.processPayment(cart);

        // Assert the output contains the expected success message
        assertTrue(outContent.toString().contains("***** PAYMENT APPROVED *****"));
    }*/

    /**
     * Tests the processPayment method for a failed payment with an empty cart.
     */
/*
    @Test
    public void testProcessPaymentFailed() {
        // Set up an empty Cart and Customer for testing
        Cart cart = new Cart();
        Customer customer = new Customer("customer@example.com", "1234567890", "customer1", "password", 1, "ahtab Ameli", "333 University Way");
        customer.setCart(cart);

        // Call processPayment method
        PaymentProcessor.processPayment(cart);

        // Assert the output contains the expected failure message
        assertTrue(outContent.toString().contains("PAYMENT CANNOT BE PROCESSED: SHOPPING CART IS EMPTY!"));
    }
*/

    /**
     * Tests the processPayment method for an empty cart.
     */
/*    @Test
*//*    public void testProcessPaymentEmptyCart() {
        // Set up Book, empty Cart, and Customer for testing
        BookStoreManagement bookStoreManagement = new BookStoreManagement();
        Book book = new Book(123, "Book 1", "Author 1", "Publisher 1", 10, 29.99);
        bookStoreManagement.addBook(book);

        Cart cart = new Cart();
        Customer customer = new Customer("customer@example.com", "1234567890", "customer1", "password", 1, "Mahtab Ameli", "333 University Way");
        customer.setCart(cart);

        PaymentProcessor.processPayment(cart);

        // Assert the output contains the expected empty cart message
        assertTrue(outContent.toString().contains("PAYMENT CANNOT BE PROCESSED: SHOPPING CART IS EMPTY!"));
    }*/




    /**
     * Tests the generateTransactionNumber method to ensure transaction numbers are incremented correctly.
     */
    @Test
    public void testGenerateTransactionNumber() {
        // Get two consecutive transaction numbers
        int transactionNumber1 = PaymentProcessor.generateTransactionNumber();
        int transactionNumber2 = PaymentProcessor.generateTransactionNumber();

        // Assert that the transaction numbers are consecutive
        assertEquals(transactionNumber1 + 1, transactionNumber2);
    }

    /**
     * Restores the original System.Out after testing
     */
    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}
