package hotel.tests.services;

import hotel.entities.User;
import hotel.repositories.UserRepository;
import hotel.tests.services.stubs.UserRepositoryStub;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UserTests {
    private static User user;
    private static UserRepositoryStub userRepositoryStub;
    private static UserRepository userRepository;
    private static List<User> userListActual;
    private static List<User> userListExpected;

    @Test
    void addUserCorrect() {
        userRepository.save(new User("first2nameTestUser1", "secondnameTestUser1",
                "+380993694511", "Test1@ukr.net"));

        userRepository.save(new User("first2nameTestUser2", "secondnameTestUser2",
                "+380993694512", "Test@ukr.net"));
        userRepository.save(new User("first2nameTestUser3", "secondnameTestUser2",
                "+380993694513", "Test1@ukr.net"));

        userListActual = new ArrayList<>();


    }

    @Test
    void addUserNegative() {

    }
}
