package com.example.projekt.repository;

import com.example.projekt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(path = "users", collectionResourceRel = "users")
public interface UserJpaRepository extends JpaRepository<User,Integer> {
    List<User> findByNameContains(String name);
    User findByLogin(String login);
    User findByEmail(String email);
}
