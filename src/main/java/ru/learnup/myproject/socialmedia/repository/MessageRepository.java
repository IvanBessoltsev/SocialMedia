package ru.learnup.myproject.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.myproject.socialmedia.entity.Message;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByMessageContaining(String fi);
}
