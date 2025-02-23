package pl.library.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
