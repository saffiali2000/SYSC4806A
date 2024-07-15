package model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

//User SuperClass
//Both Customers and Owners are Users, thus sharing several fields such as an id, email, username, ect.
//This class has getters for these fields, making the Customer and Owner classes less condensed
@MappedSuperclass
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String email;
    private String phoneNumber;
    private String username;
    private String password;
    private String name;
    private String address;

    public User(String email, String phoneNumber, String username, String password, String name, String address){
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public User(){};

    public String getEmail(){
        return email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

}
