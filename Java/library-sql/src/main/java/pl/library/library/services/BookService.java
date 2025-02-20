package pl.library.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.library.library.entities.Book;
import pl.library.library.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public Book findById(long id) {
        return bookRepository.findById(id);
    }
    public List<Book> findAllByAuthor(String author){
        return bookRepository.findAllByAuthor(author);
    }
    public List<Book> findAll(){
        List<Book> books = bookRepository.findAll();
        System.out.println("Books: " + books);
        return books;
    }
    public Book findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
