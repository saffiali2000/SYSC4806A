package model;

import entity.Book;
import entity.BookStoreManagement;
import entity.Owner;
import org.junit.Test;

import static org.junit.Assert.*;

//TEST CLASS
//Tests functions of the Owner class

public class OwnerTest {

    @Test
    public void addBookToStoreTest() {
        //Create new bookstore and Owner
        BookStoreManagement bookstore = new BookStoreManagement();
        Owner testOwner = new Owner("owneremail", "12345", "Owner", "ImTheBoss", "Boss", "bossstreet");

        //Create test books
        Book book = new Book(123,1, "TEST", "Hamza Zafar", "Carleton", 10,1.99);
        Book book2 = new Book(128,1, ":D", "Hamza Zafar", "Carleton", 10,1.99);

        //Assign the created bookstore to the Owners ownerStore variable then test adding books to the owners bookstore
        testOwner.setOwnersStore(bookstore);
        testOwner.addBookToStore(book);
        testOwner.addBookToStore(book2);
        assertEquals(2, testOwner.getBookStore().size());
        //After test, remove any contents that may get into the front end/DBs
        testOwner.removeBookFromStore(book);
        testOwner.removeBookFromStore(book2);
        assertEquals(0, testOwner.getBookStore().size());
    }

    @Test
    public void removeBookFromStoreTest(){
        //Create new bookstore and Owner
        BookStoreManagement bookstore = new BookStoreManagement();
        Owner testOwner = new Owner("owneremail", "12345", "Owner", "ImTheBoss", "Boss", "bossstreet");

        //Create test books
        Book book = new Book(123,1, "TEST", "Hamza Zafar", "Carleton", 10,1.99);
        Book book2 = new Book(128, 1,":D", "Hamza Zafar", "Carleton", 10,1.99);

        //Assign the created bookstore to the Owners ownerStore variable then add books to the owners bookstore, after test removing the books
        testOwner.setOwnersStore(bookstore);
        testOwner.addBookToStore(book);
        testOwner.addBookToStore(book2);
        assertEquals(2, testOwner.getBookStore().size());
        testOwner.removeBookFromStore(book);
        assertEquals(1, testOwner.getBookStore().size());
        testOwner.removeBookFromStore(book2);
        assertEquals(0, testOwner.getBookStore().size());
    }

    @Test
    public void updateStoreQuantityTest(){
        //Create new bookstore and Owner
        BookStoreManagement bookstore = new BookStoreManagement();
        Owner testOwner = new Owner("owneremail", "12345", "Owner", "ImTheBoss", "Boss", "bossstreet");

        //Create test books
        Book book = new Book(123,1, "TEST", "Hamza Zafar", "Carleton", 10,1.99);

        //Assign the created bookstore to the Owners ownerStore variable then add books to the owners bookstore, after test removing the books
        testOwner.setOwnersStore(bookstore);
        testOwner.addBookToStore(book);
        testOwner.updateStoreQuantity(123, -3);
        testOwner.updateStoreQuantity(128, 0);
        assertEquals(10, book.getQuantity());
        //After test, remove any contents that may get into the front end/DBs
        testOwner.removeBookFromStore(book);
        assertEquals(0, testOwner.getBookStore().size());
    }



}
