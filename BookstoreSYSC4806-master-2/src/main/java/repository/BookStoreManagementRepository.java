package repository;

import entity.BookStoreManagement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Repository Class
//CRUD Repository that contains BookStoreManagements, with each assigned a Long id
@Repository
public interface BookStoreManagementRepository extends CrudRepository<BookStoreManagement, Long>{
    //Find a BookStoreManagement in the repository by their assigned id
    Optional<BookStoreManagement> findById(long id);
}
