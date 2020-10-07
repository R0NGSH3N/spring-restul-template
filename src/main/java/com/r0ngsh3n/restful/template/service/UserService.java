package com.r0ngsh3n.restful.template.service;

import com.r0ngsh3n.restful.template.model.Item;
import com.r0ngsh3n.restful.template.model.User;
import com.r0ngsh3n.restful.template.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User addUser(User user) {
        repository.save(user);
        return user;
    }

    public User addItem(Long userId, Item item){
        return null;
    }

    public List<User> getUserByName(String name){
        try (Stream<User> stream = repository.findByName(name)) {
            return stream.collect(Collectors.toList());
        }
    }

    public User getUserById(Long userId){
        Optional<User> user = repository.findById(userId);
        return user.orElseThrow(() -> new RuntimeException(userId + " user not found"));
    }

    public User findUserWithItems(Long userId){
        return repository.findUserAndItemsWithUserId(userId);
    }


}
