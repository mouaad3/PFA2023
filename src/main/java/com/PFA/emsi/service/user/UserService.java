package com.PFA.emsi.service.user;

import com.PFA.emsi.model.User;
import com.PFA.emsi.repository.UserRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public User updateUser(User updatedUser);
    public User createUser(User user);

    public User getUserById(Long id);

    public List<User> getAllUsers();

    public void deleteUser(Long id);
}
