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
        var users = userDao.listUsers();
        return users;
    }

}
