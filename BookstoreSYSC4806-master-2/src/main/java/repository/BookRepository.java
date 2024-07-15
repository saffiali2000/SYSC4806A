package repository;

import java.util.Optional;

import entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//Repository Class
//CRUD Repository that contains Books, with each assigned a Long id
//ToDo There are two find by Isbn, figure out which one is needed
@Repository
public interface BookRepository extends CrudRepository <Book, Long>{
    //Find a Book in the repository by their assigned id
    Book findById(long id);
    //Find a Book in the repository by their isbn
    Optional<Book> findByIsbn(int isbn);

    //Find All Books and order by recommended First
    Iterable<Book> findAllByOrderByRecommendedDesc();

    //Find a Book in the repository by their isbn
    Iterable<Book> findBooksByIsbn(int isbn);
    //Find a Book in the repository by their publisher
    Iterable<Book> findBooksByPublisher(String publisher);
    //Find a Book in the repository by their author
    Iterable<Book> findBooksByAuthor(String author);
    //Find a Book in the repository by their name
    Iterable<Book> findBooksByBookName(String bookName);
    Optional<Book> findById(Book.BookId bookId);

    void deleteByIsbn(int isbn);


}
