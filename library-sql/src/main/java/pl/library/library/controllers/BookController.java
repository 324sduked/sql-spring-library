package pl.library.library.controllers;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.library.library.services.BookService;
import pl.library.library.entities.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

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
       return bookService.deleteBook(id);
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
        @GetMapping("/find/{title}")
    public Book findByTitle(@PathVariable String title) { return bookService.findByTitle(title); }
    }
