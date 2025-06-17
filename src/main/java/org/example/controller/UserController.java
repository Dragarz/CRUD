package org.example.controller;

import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String printUsers(ModelMap model) {
        var users = userService.listUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> deleteUser(@RequestParam String id) {
        try {
            userService.deleteUser(Long.parseLong(id));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Void> addUser(@RequestParam String name, @RequestParam String lastName, @RequestParam String email) {
        try {
            userService.addUser(name, lastName, email);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping(value = "/update")
    public ResponseEntity<Void> updateUser(@RequestParam String id, @RequestParam String name, @RequestParam String lastName, @RequestParam String email) {
        try {
            userService.updateUser(Long.parseLong(id), name, lastName, email);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}