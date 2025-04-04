package pl.library.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.library.library.entities.User;
import pl.library.library.repositories.UserRepository;
import pl.library.library.services.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setUser_id(2L);
        user.setEmail("test@test.com");
        user.setFirst_name("TestFirstName");
        user.setLast_name("TestLastName");
    }

    private void verifyUserProperties(User user) {
        assertNotNull(user);
        assertEquals("TestFirstName", user.getFirst_name());
        assertEquals("TestLastName", user.getLast_name());
        assertEquals(2L, user.getUser_id());
        assertEquals("test@test.com", user.getEmail());
    }

    @Test
     void testAddUser() {
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User savedUser = userRepository.save(user);
        verifyUserProperties(savedUser);
    }

}
