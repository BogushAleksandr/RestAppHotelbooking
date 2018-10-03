package hotel.tests.services;

import hotel.entities.User;
import hotel.repositories.UserRepository;
import org.junit.jupiter.api.Test;

public class UserTests {
    private static User user;
    private static UserRepository userRepository;
    private static UserRepository getUserRepository;

    @Test
    void addUserCorrect() {
        userRepository.save(new User("firstnameTestUser1", "secondnameTestUser1", "+380993694511", "Test1@ukr.net"));


    }

    @Test
    void addUserNegative() {

    }
}
