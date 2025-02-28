package pl.library.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.library.library.services.BookService;
import pl.library.library.entities.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
        @Autowired
        BookService  bookService;

    @GetMapping("/test")
    public int test(){
        return 1;
    }

        @PostMapping("/add")
        public Book addBook(@RequestBody Book book) {
            return bookService.save(book);
        }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        boolean deleted = bookService.deleteBook(id);

        if (deleted) {
            return ResponseEntity.ok("Book deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found.");
        }
    }


    @GetMapping("/all")
        public List<Book> getAllBooks() {
            return bookService.findAll();
        }
        @GetMapping("/id/{id}")
        public Book getBookById(@PathVariable long id) {
            return bookService.findById(id);
        }
        @GetMapping("/count/{title}")
        public int countByTitle(@PathVariable String title) {
            return bookService.countBookByTitle(title);
        }
    }
