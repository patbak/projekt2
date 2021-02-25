package com.example.projekt.repository;

import com.example.projekt.dto.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "account", collectionResourceRel = "account")
public interface AccountRepository extends JpaRepository<Account,Integer> {
    Account findByLogin(String login);
    Account findByEmail(String email);
}
