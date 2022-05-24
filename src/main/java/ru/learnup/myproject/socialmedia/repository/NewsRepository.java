package ru.learnup.myproject.socialmedia.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.myproject.socialmedia.entity.News;
import ru.learnup.myproject.socialmedia.entity.Posts;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findAllByNewsContains(String fi);

}
