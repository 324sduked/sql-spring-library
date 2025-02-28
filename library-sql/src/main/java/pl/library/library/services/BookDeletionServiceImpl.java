package pl.library.library.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.library.library.repositories.BookRepository;

@Service
public class BookDeletionServiceImpl implements BookDeletionService {

    private final BookRepository bookRepository;

    public BookDeletionServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseEntity<String> deleteBook(Long id) {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return ResponseEntity.ok("Book deleted.");
        }
        return ResponseEntity.notFound().build();
    }
}
