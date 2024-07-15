package model;

import entity.Book;
import entity.Cart;
import entity.Customer;
import org.junit.Test;

import static org.junit.Assert.*;

//TEST CLASS
//Tests functions of the Customer class

public class CustomerTest {

    @Test
    public void testCustomerPurchaseHistory(){

        //Create test Customer and test Books
        Customer customer = new Customer("teste@mail", "12345", "testMan", "password", "Man", "testAddress");
        Book book1 = new Book(123,1, "TEST", "Hamza Zafar", "Carleton", 10,1.99);
        Book book2 = new Book(128,1, ":D", "Hamza Zafar", "Carleton", 10,1.99);

        //Test Adding books to purchaseHistory
        customer.addToPurchaseHistory(book1);
        assertEquals(1, customer.getPurchaseHistory().size());
        customer.printOutPurchaseHistory();

        customer.addToPurchaseHistory(book2);
        assertEquals(2, customer.getPurchaseHistory().size());
        customer.printOutPurchaseHistory();

    }
}
