package com.pruebatecnica.pruebatecnica.controller;

import com.pruebatecnica.pruebatecnica.model.User;
import com.pruebatecnica.pruebatecnica.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    private List<User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    private ResponseEntity<User> saveUser(@RequestBody User userParam) {
        User user = userService.createUser(userParam);

        return user == null ?
                new ResponseEntity<>(null, HttpStatus.BAD_REQUEST)
                :
                new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") Long id) {
        boolean status = userService.deleteUser(id);
        Map<String, Boolean> response = new HashMap<>();

        response.put("success", status);

        return status ?
                new ResponseEntity<>(response, HttpStatus.OK)
                :
                new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
