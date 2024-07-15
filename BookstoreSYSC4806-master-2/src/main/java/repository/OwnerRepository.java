package repository;

import entity.Owner;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

//Repository class
//CRUD Repository that contains Owners, with each assigned a Long id
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    //Find a Owner in the repository by their assigned id
    Optional<Owner> findById(long id);

    //Find a Customer in the repository by their username
    Optional<Owner> findByUsername(String username);
}

