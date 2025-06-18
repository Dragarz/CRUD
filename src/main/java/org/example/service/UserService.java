package org.example.service;

import java.util.List;
import org.example.model.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
    List<User> listUsers();

    void deleteUser(long userId);

    void addUser(String name, String lastName, String email);

    void updateUser(long id, String name, String lastName, String email);
}
