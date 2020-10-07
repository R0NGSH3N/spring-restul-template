package com.r0ngsh3n.restful.template.repository;

import com.r0ngsh3n.restful.template.model.User;

public interface CustomizedUserRepository {
    public User findUserAndItemsWithUserId(Long userId);
}
