package pl.library.library.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.library.library.repositories.UserRepository;

@Service
public class UserDeletionServiceImpl implements UserDeletionService {

    private final UserRepository userRepository;

    public UserDeletionServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public ResponseEntity<String> deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok("User deleted successfully");
        }
        return ResponseEntity.notFound().build();
    }
}
