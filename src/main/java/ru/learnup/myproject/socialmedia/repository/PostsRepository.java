package ru.learnup.myproject.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.learnup.myproject.socialmedia.entity.Friends;
import ru.learnup.myproject.socialmedia.entity.Posts;

import java.util.List;


@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findAllByPostContains(String fi);
}
