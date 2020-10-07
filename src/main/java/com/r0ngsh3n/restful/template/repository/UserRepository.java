package com.r0ngsh3n.restful.template.repository;

import com.r0ngsh3n.restful.template.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, CustomizedUserRepository{

    @Nullable
    Stream<User> findByName(@Nullable String name);

    Optional<User> findByEmail(String email);

}
