package pl.library.library.services;

import org.springframework.http.ResponseEntity;

public interface UserDeletionService {
    ResponseEntity<String> deleteUser(Long id);
}
