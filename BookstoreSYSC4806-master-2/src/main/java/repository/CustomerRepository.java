package repository;

import entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//Repository Class
//CRUD Repository that contains Customers, with each assigned a Long id
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    //Find a Customer in the repository by their assigned id
    Optional<Customer> findById(long id);

    //Find a Customer in the repository by their username
    Optional<Customer> findByUsername(String username);

}

