package avd.com.bookmyshow.Controllers;


import avd.com.bookmyshow.Models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    private ArrayList<User> users = new ArrayList<>();

    @PostMapping("/")
    public User createUser(@RequestBody User user) {
        users.add(user);

        return user;
    }
    @GetMapping("/")
    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(@PathVariable("id") int id) {
        return users.get(id);
    }
}
