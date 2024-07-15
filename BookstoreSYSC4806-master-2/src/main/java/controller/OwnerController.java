package controller;

import entity.Book;
import entity.BookStoreManagement;
import entity.Owner;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.BookRepository;
import repository.BookStoreManagementRepository;
import repository.OwnerRepository;

import java.util.Optional;

@Controller
public class OwnerController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    BookStoreManagementRepository bookStoreRepository;

    /**
     * Method OwnerSignup to direct users to the owner signup page
     * @return a direction to the next appropriate page
     */

    @GetMapping("/owner_portal")
    public String Owner(Model model, HttpSession session) {
        String username = (String) session.getAttribute("username");
        Optional<Owner> owner = ownerRepository.findByUsername(username);
        if (owner.isEmpty()) {
            return "redirect:/owner_login";
        }

        Optional<BookStoreManagement> bookStoreManagementOptional = bookStoreRepository.findById(owner.get().getId());
        if (bookStoreManagementOptional.isEmpty()) {
            return "redirect:/owner_login";
        }

        BookStoreManagement bookStoreManagement = bookStoreManagementOptional.get();
        Iterable<Book> books = bookStoreManagement.getBookList();

        model.addAttribute("owner", owner.get());
        model.addAttribute("books", books);
        return "owner_portal";
    }

    @GetMapping("/upload_book")
    public String UploadBook(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        Optional<Owner> owner = ownerRepository.findByUsername(username);
        if (owner.isEmpty()) {
            return "redirect:/owner_login";
        }

        model.addAttribute("owner", owner.get());
        return "upload_book";
    }

    @PostMapping(value = "/upload_book", params = "AddBook")
    public String UploadBookControl(
            @RequestParam(name = "isbn", required = false, defaultValue = "") int isbn,
            @RequestParam(name = "bookName", required = false, defaultValue = "") String bookName,
            @RequestParam(name = "publisher", required = false, defaultValue = "") String publisher,
            @RequestParam(name = "author", required = false, defaultValue = "") String author,
            @RequestParam(name = "quantity", required = false, defaultValue = "") String quantity,
            @RequestParam(name = "price", required = false, defaultValue = "") String price,
            HttpSession session, Model model) {

        String username = (String) session.getAttribute("username");
        Optional<Owner> owner = ownerRepository.findByUsername(username);
        if (owner.isEmpty()) {
            return "redirect:/owner_login";
        }

        Optional<BookStoreManagement> bookStoreManagementOptional = bookStoreRepository.findById(owner.get().getId());
        if (bookStoreManagementOptional.isEmpty()) {
            return "redirect:/owner_login";
        }

        BookStoreManagement bookStoreManagement = bookStoreManagementOptional.get();
        model.addAttribute("owner", owner.get());

        if (Integer.toString(isbn).isEmpty() || bookName.isEmpty() || author.isEmpty() || publisher.isEmpty() || quantity.isEmpty() || price.isEmpty()) {
            model.addAttribute("upload_book_error", "some inputs are missing!");
            return "upload_book";
        }

        try {
            double newPrice = Double.parseDouble(price);
            int newQuantity = Integer.parseInt(quantity);

            if (newPrice >= 0 && newQuantity >= 0) {

                Book newBook = new Book(isbn, bookStoreManagement.getBookList().size() + 1, bookName, author, publisher, newQuantity, newPrice);

                bookStoreManagement.addBook(newBook);
                bookRepository.save(newBook);
                bookStoreRepository.save(bookStoreManagement);

                return "redirect:/owner_portal";
            } else {
                model.addAttribute("upload_book_error", "Please only enter non-negative numbers!");
            }
        } catch (NumberFormatException nfe) {
            model.addAttribute("upload_book_error", "Formatting error, some inputs do not have correct formatting");
        }
        return "upload_book";
    }

    @Transactional
    @PostMapping("/edit_book")
    public String editBook(
            @RequestParam(name = "isbn", required = true) int isbn,
            @RequestParam(name = "quantity", required = false, defaultValue = "0") int quantity,
            @RequestParam(name = "edit_book", required = false) String editBook,
            @RequestParam(name = "delete_book", required = false) String deleteBook,
            HttpSession session, Model model) {

        String username = (String) session.getAttribute("username");
        Optional<Owner> owner = ownerRepository.findByUsername(username);

        if (owner.isEmpty()) {
            return "redirect:/owner_login";
        }

        model.addAttribute("owner", owner.get());

        try {
            Optional<BookStoreManagement> bookStoreManagementOptional = bookStoreRepository.findById(owner.get().getId());

            if (bookStoreManagementOptional.isEmpty()) {
                return "redirect:/owner_login";
            }

            BookStoreManagement bookStoreManagement = bookStoreManagementOptional.get();
            if (editBook != null) {
                // Edit Book
                bookStoreManagement.updateQuantity(isbn, quantity);
            } else if (deleteBook != null) {
                // Delete Book
                bookStoreManagement.removeBook(isbn);

                // Remove the book from the repository
                bookRepository.deleteByIsbn(isbn);
            }

            // Save the changes to the book store
            bookStoreRepository.save(bookStoreManagement);

            return "redirect:/owner_portal";
        } catch (NumberFormatException nfe) {
            model.addAttribute("book_search_error", "Formatting error, ISBN should be a number");
            return "edit_book";
        }
    }



}
