package org.example.service;

import java.util.List;
import org.example.dao.UserDao;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }

    @Override
    public void deleteUser(long userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void addUser(String name, String lastName, String email) {
        userDao.add(new User(name, lastName, email));
    }

    @Override
    public void updateUser(long id, String name, String lastName, String email) {
        userDao.updateUser(id, name, lastName, email);
    }

}
