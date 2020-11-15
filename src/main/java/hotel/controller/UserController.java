package hotel.controller;

import hotel.entities.User;
import hotel.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/find/all/User")
    private List<User> findallUsers() {
        return userService.findedallUser();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json")
    private User registerUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping("/saveUser")
    private String addUsers() {
        return userService.addUsers();
    }
}