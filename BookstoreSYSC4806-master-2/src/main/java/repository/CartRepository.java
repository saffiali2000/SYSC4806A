package repository;

import entity.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

//Repository Class
//CRUD Repository that contains Carts, with each assigned a Long id
public interface CartRepository extends CrudRepository<Cart, Long> {
    //Find a Cart in the repository by their assigned id
    Optional<Cart> findById(long id);

    //Find a Customer in the repository by their username
    //Optional<Cart> findByCustomer(String customer);

    //Delete a Cart in the repository by their assigned id
    Optional<Cart> deleteCartById(long id);
}

