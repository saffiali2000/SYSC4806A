package entity;

import jakarta.persistence.*;

import java.io.Serializable;

//Book Entity Class
//A Book is an object that has several fields to describe one such as its isbn, name, author, ect.
//This class has getters for all the Books fields, providing a means for other Entities such as Owner
//to adding or removing specific books from their bookStore based on their isbn for example.
@Entity
public class Book implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int isbn;
    private int version;

    public String bookName;
    private String author;
    private String publisher;
    private int quantity;
    private double price;
    private boolean recommended;// to indicate if the book is recommended
    private int cartQuantity; // Quantity of this book in the cart
    private long cartId; // Identifier for the cart this book is in


    //empty constructor for JPA
    public Book() {

    }
    public Book(int isbn, int version, String bookName, String author, String publisher, int quantity, double price) {
        this.isbn = isbn;
        this.version = version;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.quantity = quantity;
        this.price = price;
        this.cartQuantity = 0; // Default quantity in cart is 0, it indicates how many books of the same title is in a customer's cart
        this.recommended = false;
    }

    public static class BookId implements Serializable  {
        protected String isbn;
        protected int version;

        public BookId(String isbn, int version) {
            this.isbn = isbn;
            this.version = version;
        }

        public BookId() {}

        public String getIsbn() {
            return this.isbn;
        }

        public int getVersion() {
            return this.version;
        }

        @Override
        public String toString() {
            return isbn + ":" + version;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }

    public int getIsbn() {
        return isbn;
    }
    public int getVersion() {
        return version;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {return price;}

    public void addQuantity(int amount){
        this.quantity = quantity + amount;
    }

    public void reduceQuantity(){
        this.quantity = quantity - 1;
    }

    public long getId() {
        return id;
    }

    public int getCartQuantity(){return cartQuantity;}
    public void setCartQuantity(int quantity){cartQuantity = quantity;}

    // Cart-related methods
    public void addToCart(int quantity) {
        // Check if sufficient stock is available
        if (this.quantity < quantity) {
            throw new IllegalArgumentException("Not enough stock available");
        }
        //this.quantity -= quantity;
        this.cartQuantity += quantity;
    }

    public void updateQuantity (int quantity) {
        this.quantity = this.quantity- quantity;
        }
    @Override
    public String toString() {
        return String.format(
                "Book[id=%d, isbn='%s', bookName='%s', version=%s, author='%s', publisher='%s', quantity='%s', price='%s', cartQuantity='%s']",
                id, isbn, bookName, version, author, publisher, quantity, price, cartQuantity);
    }
    public boolean getRecommended() {return recommended;}
    public void setRecommended(boolean recommended) {this.recommended = recommended;}

}