package com.accenture.spring.user;

import com.accenture.spring.user.domain.User;
import com.accenture.spring.user.repository.LogEntryRepository;
import com.accenture.spring.user.repository.UserRepository;
import com.accenture.spring.user.service.LogService;
import com.accenture.spring.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = UserManagementApplication.class)

@SpringBootTest
class UserServiceImplTest {

    @MockBean
    LogService logService;

    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogEntryRepository logEntryRepository;

    @Test
    void getAllUsers() {
        assertEquals(3, userService.getAllUsers().size());
    }

    @Test
    public void testCreateUser() {

        userRepository.deleteAll();

        assertEquals(0, userRepository.count());
        assertEquals(0, logEntryRepository.count());

        User user = new User("Thorsten", "Maier");
        userService.createUser(user);

        assertEquals(1, userRepository.count());
        assertEquals(1, logEntryRepository.count());

        try {
            User user2 = new User("Thorsten", "Maier");
            userService.createUser(user2);
            fail("Exception should be thrown");
        } catch (DataAccessException e) {
            // expected exception
        } finally {
            assertEquals(1, userRepository.count());
            assertEquals(1, logEntryRepository.count());
        }
    }


}
