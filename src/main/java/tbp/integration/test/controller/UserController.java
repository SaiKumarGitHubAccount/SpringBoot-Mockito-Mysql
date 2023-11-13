package tbp.integration.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import tbp.integration.test.dao.User;
import tbp.integration.test.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> findAllUsers() {
        return service.getUsers();
    }

    @GetMapping("/getUserByAddress/{address}")
    public List<User> findUserByAddress(@PathVariable String address) {
        return service.getUserbyAddress(address);
    }


}