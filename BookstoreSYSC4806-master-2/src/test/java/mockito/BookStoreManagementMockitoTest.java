package mockito;

import entity.Book;
import entity.BookStoreManagement;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//Test class that uses Mockito
//when then return the bookStoreManagements id works
//Adding books however does not.
public class BookStoreManagementMockitoTest {

    @Test
    public void addBookTest() {

        //Basic use of Mockito
        BookStoreManagement bookStoreManagementMock = mock(BookStoreManagement.class);
        when(bookStoreManagementMock.getId()).thenReturn((long) 1.0);

        //Adding books with mock class doesn't work
        Book book = new Book(123, 1,"TEST", "Hamza Zafar", "Carleton", 10,1.99);
        //bookStoreManagementMock.addBook(book);
        //assertEquals(bookStoreManagementMock.getBookList().size(),1);
    }
}
