package model;

import entity.Book;
import entity.BookStoreManagement;
import org.junit.Test;

import static org.junit.Assert.*;
//TEST CLASS
//Tests functions of the BookStoreManagement class
public class BookStoreManagementTest {

    @Test
    public void addBookTest() {
        BookStoreManagement bookstore = new BookStoreManagement();

        Book book = new Book(123, 1,"TEST", "Hamza Zafar", "Carleton", 10,1.99);
        Book book2 = new Book(128, 1,":D", "Hamza Zafar", "Carleton", 10,1.99);

        bookstore.addBook(book);
        bookstore.addBook(book2);
        assertEquals(2, bookstore.getBookList().size());
        //After test, remove any contents that may get into the front end/DBs
        bookstore.removeBook(book.getIsbn());
        bookstore.removeBook(book2.getIsbn());
        assertEquals(0, bookstore.getBookList().size());

    }

    @Test
    public void updateQuantityTestPositive() {
        BookStoreManagement bookstore = new BookStoreManagement();
        Book book = new Book(123,1, "TEST", "Hamza Zafar", "Carleton", 10,1.99);
        bookstore.addBook(book);
        bookstore.updateQuantity(book.getIsbn(), 20);

        assertEquals(30, book.getQuantity());
        //After test, remove any contents that may get into the front end/DBs
        bookstore.removeBook(book.getIsbn());
        assertEquals(0, bookstore.getBookList().size());
    }
    @Test
    public void updateQuantityTestNegative() {
        BookStoreManagement bookstore = new BookStoreManagement();
        Book book = new Book(123,1, "TEST", "Hamza Zafar", "Carleton", 10,1.99);
        bookstore.addBook(book);
        bookstore.updateQuantity(123, -3);
        bookstore.updateQuantity(123, 0);
        assertEquals(10, book.getQuantity());
        //After test, remove any contents that may get into the front end/DBs
        bookstore.removeBook(book.getIsbn());
        assertEquals(0, bookstore.getBookList().size());
    }

    @Test
    public void removeBookTest() {
        BookStoreManagement bookstore = new BookStoreManagement();

        Book book = new Book(123,1, "TEST", "Hamza Zafar", "Carleton", 10,1.99);
        Book book2 = new Book(128, 1,":D", "Hamza Zafar", "Carleton", 10,1.99);
        Book book3 = new Book(125,1, ":D", "Hamza Zafar", "Carleton", 10,1.99);
        Book book4 = new Book(120,1, ":D", "Hamza Zafar", "Carleton", 10,1.99);

        bookstore.addBook(book);
        bookstore.addBook(book2);
        bookstore.addBook(book3);
        bookstore.addBook(book4);

        assertTrue(bookstore.getBookList().contains(book4));
        assertEquals(bookstore.getBookList().size(),4);

        bookstore.removeBook(book4.getIsbn());

        assertEquals(bookstore.getBookList().size(),3);
        //After test, remove any contents that may get into the front end/DBs
        bookstore.removeBook(book.getIsbn());
        bookstore.removeBook(book2.getIsbn());
        bookstore.removeBook(book3.getIsbn());
        bookstore.removeBook(book4.getIsbn());
        assertEquals(0, bookstore.getBookList().size());
    }
}
