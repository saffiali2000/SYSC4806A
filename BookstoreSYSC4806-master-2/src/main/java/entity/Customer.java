package entity;

import entity.Book;
import entity.Cart;
import jakarta.persistence.*;
import model.PaymentProcessor;
import model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//Customer Entity Class
//The Customer has User fields along with its exclusive purchaseHistory and cart
//The Customer has a OneToOne relationship with the Cart and OneToMany with Books
//The Customer has several methods to add Books into their cart and their purchaseHistory
//ToDo FIX MANY BUGS WITH CUSTOMER (Aim for milestone 2)
@Entity
public class Customer extends User implements Serializable {

    @OneToMany
    List<Book> purchaseHistory;

    @OneToOne
    private Cart cart;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    public Customer(){
        super();
    };

    public Customer(String email, String phoneNumber, String username, String password, String name, String address) {
        super(email, phoneNumber, username, password, name, address);
        this.purchaseHistory = new ArrayList<>();
    }

    public void addToPurchaseHistory(Book book){
        purchaseHistory.add(book);
    }

    public void printOutPurchaseHistory(){
        int val = 0;
        if(purchaseHistory.isEmpty()){
            System.out.println("The purchase history is empty!");
            return;
        }
        while(purchaseHistory.size() > val){
            System.out.println(purchaseHistory.get(val).getBookName());
            val++;
        }
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart){
        this.cart = cart;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setPurchaseHistory(List history){
        this.purchaseHistory = history;
    }

    public List<Book> getPurchaseHistory(){
        return purchaseHistory;
    }
}

