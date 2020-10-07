package com.r0ngsh3n.restful.template.controller;

import com.r0ngsh3n.restful.template.model.Item;
import com.r0ngsh3n.restful.template.model.User;
import com.r0ngsh3n.restful.template.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    private String[] s;

    @PostMapping("/addUser")
    public User addUser(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }

    @PostMapping("/addItems")
    public User addUser(@RequestBody @Valid Item item, Long userId) {
        return userService.addItem(userId, item);
    }

    @GetMapping("/getUserWithItems/{id}")
    public User getUsersByName(@PathVariable Long id) {
        return userService.findUserWithItems(id);
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

}
