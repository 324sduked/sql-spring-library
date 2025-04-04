package pl.library.library.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pl.library.library.entities.User;
import pl.library.library.repositories.UserRepository;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    UserDeletionServiceImpl userDeletionService;

    @Autowired
    public UserService(UserRepository userRepository, UserDeletionServiceImpl userDeletionService) {
        this.userRepository = userRepository;
        this.userDeletionService = userDeletionService;
    }
    public ResponseEntity<String> deleteUser(Long id) {return userDeletionService.deleteUser(id);}
    public List<User> getUsers() { return userRepository.findAll(); }
    public User addUser(User user) {
        return userRepository.save(user);
    }
    public List<User> GetAllUsers() {
        return userRepository.findAll();
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User findById(long user_id) {
        return userRepository.findById(user_id);
    }

}
