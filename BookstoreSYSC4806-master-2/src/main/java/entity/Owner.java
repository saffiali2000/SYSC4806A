package entity;

import entity.Book;
import entity.BookStoreManagement;
import jakarta.persistence.*;
import model.User;

import java.io.Serializable;
import java.util.Collection;

//Owner Entity Class
//The Owner has User fields along with its exclusive BookStoreManagement
//The Owner has a OneToOne relationship with the BookStoreManagement
//The Owner has several methods to edit their respective bookstore such as adding or removing books
//ToDo FIX REMOVE BOOKS AND UPDATE STORE QUANTITY
@Entity
public class Owner extends User implements Serializable {

    @OneToOne
    BookStoreManagement ownersStore;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public Owner(){};
    public Owner(String email, String phoneNumber, String username, String password, String name, String address) {
        super(email, phoneNumber, username, password, name, address);
        this.setOwnersStore(new BookStoreManagement());
    }

    public void addBookToStore(Book book){
        ownersStore.addBook(book);
    }

    public void removeBookFromStore(Book book){
        ownersStore.removeBook(book.getIsbn());
    }

    public void updateStoreQuantity(int isbn, int amount){
        ownersStore.updateQuantity(isbn, amount);
    }

    public Collection<Book> getBookStore(){
        return ownersStore.getBookList();
    }

    public BookStoreManagement getOwnersStore() {
        return ownersStore;
    }
    public void setOwnersStore(BookStoreManagement store){
        this.ownersStore = store;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }
}
