package pl.library.library.services;


import org.springframework.http.ResponseEntity;

public interface BookDeletionService {
    ResponseEntity<String> deleteBook(Long id);
}
