package com.r0ngsh3n.restful.template.controller;

import com.r0ngsh3n.restful.template.model.Item;
import com.r0ngsh3n.restful.template.model.User;
import com.r0ngsh3n.restful.template.repository.UserRepository;
import com.r0ngsh3n.restful.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    private String[] s;
    private UserRepository repository;

    @PostMapping("/addUser")
    public User addUser(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }

    @PostMapping("/addItems")
    public User addUser(@RequestBody @Valid Item item, Long userId) {
        return userService.addItem(userId, item);
    }

    @PostMapping("/getUser")
    public List<User> getUsersByName(@RequestBody @Valid User user) {
        return userService.getUserByName(user.getName());
    }

}
