package com.pruebatecnica.pruebatecnica.service;

import com.pruebatecnica.pruebatecnica.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(User user);
    boolean deleteUser(Long id);
}
