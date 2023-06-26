package com.PFA.emsi.service;

import com.PFA.emsi.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
}
