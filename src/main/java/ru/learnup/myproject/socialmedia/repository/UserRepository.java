package ru.learnup.myproject.socialmedia.repository;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;
import ru.learnup.myproject.socialmedia.entity.Friends;
import ru.learnup.myproject.socialmedia.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndAndPassword(String username, String password);

    List<User> findAllBySurnameContains(String fi);



}
