package model;

import entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repository.*;

//AccessingDataJpaApplication
//The main class that gets ran to generate repositories and populate them with test objects
//Running this class is mandatory to testing the program as a whole: Model, View, Controller
//Keep the application running while testing functions of the bookstore website
@SpringBootApplication
@ComponentScan(basePackages = {"model", "controller", "repository"})
@EntityScan("entity")
@EnableJpaRepositories("repository")
public class AccessingDataJpaApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(AccessingDataJpaApplication.class);
    }
/*
    @Bean
    public CommandLineRunner group22Demo(BookRepository bookRepository,
                                         BookStoreManagementRepository bookStoreRepository,
                                         CartRepository cartRepository,
                                         OwnerRepository ownerRepository,
                                         CustomerRepository customerRepository) {
        return (args) -> {

// Create a new Owner with initial details
            Owner owner1 = new Owner("owneremail", "12345", "Owner", "ImTheBoss", "Boss", "bossstreet");
            System.out.println("Owner made");

// Retrieve the BookStoreManagement associated with the owner
            BookStoreManagement owner1BookStore = owner1.getOwnersStore();

// Save the BookStoreManagement to the database
            bookStoreRepository.save(owner1BookStore);
            System.out.println("bookstore saved");

// Save the owner to the database
            ownerRepository.save(owner1);
            System.out.println("owner saved");

// Create and save two books to the database
            Book book1 = new Book(123,1, "TEST", "Hamza Zafar", "Carleton", 10, 1.99);
            bookRepository.save(book1);
            Book book2 = new Book(128,1, ":D", "Hamza Zafar", "Carleton", 10, 1.99);
            bookRepository.save(book2);

// Associate the first book with the owner's BookStoreManagement and save changes
            owner1.getOwnersStore().addBook(book1);
            bookStoreRepository.save(owner1BookStore);
            ownerRepository.save(owner1);

// Associate the second book with the owner's BookStoreManagement
            owner1.getOwnersStore().addBook(book2);
            System.out.println(owner1.getOwnersStore().getBookList());


            Cart cart = new Cart();
            cartRepository.save(cart);
            System.out.println("Cart saved with ID: " + cart.getId());

            Customer customer = new Customer("teste@mail", "12345", "testMan", "password", "Man", "testAddress");
            customer.setCart(cart);
            customerRepository.save(customer);
            System.out.println("Customer saved with ID: " + customer.getId());
            Customer retrievedCustomer = customerRepository.findById(customer.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid address book ID"));

            if (retrievedCustomer != null) {
                // Check if the associated Cart is not null
                Cart retrievedCart = retrievedCustomer.getCart();

                if (retrievedCart != null) {
                    System.out.println("Customer and associated Cart retrieved successfully:");
                    System.out.println("Customer Name: " + retrievedCustomer.getName());
                    System.out.println("Cart ID: " + retrievedCart.getId());
                } else {
                    System.out.println("Error: Associated Cart is null.");
                }
            } else {
                System.out.println("Error: Customer not found.");
            }

        };
    }


 */
}
