package hotel.tests.services;

import hotel.entities.User;
import hotel.repositories.UserRepository;
import hotel.services.UserService;
import hotel.tests.services.stubs.UserRepositoryStub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

public class UserTests {
    private static UserService userService;
    private static User user1;
    private static User user2;
    private static User user3;
    private static List<User> userListExpected;
    private static List<User> userListActual;
    private static UserRepositoryStub userRepositoryStub;
    private static UserRepository userRepository;

    @BeforeAll
    static void testaddUser() {
        userRepository = new UserRepositoryStub();
        userService = new UserService(userRepository);
        user1 = new User("first2nameTestUser1", "secondnameTestUser1", "+380993694511", "Test1@ukr.net");
        user2 = new User("first2nameTestUser2", "secondnameTestUser2", "+380993694511", "Test2@ukr.net");
        user3 = new User("first2nameTestUser3", "secondnameTestUser3", "+380993694511", "Test3@ukr.net");
    }

    @Test
    void addUserCorrect() {
        userListExpected = new ArrayList<>();
        userListExpected.add(user1);
        userListActual = new ArrayList<>();
        userListActual.add(user1);
        assertEquals(userListExpected, userListActual);
    }

    @Test
    void addUserNegative() {
        userListExpected = new ArrayList<>();
        userListExpected.add(user2);
        userListActual = new ArrayList<>();
        userListActual.add(user1);
        assertNotEquals(userListExpected, userListActual);
    }
}
