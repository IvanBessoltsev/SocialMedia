package ru.learnup.myproject.socialmedia.repository;

import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;
import ru.learnup.myproject.socialmedia.entity.Friends;

import java.util.List;


@Repository
public interface FriendsRepository extends JpaRepository<Friends, Long> {

    List<Friends> findAllByNameContaining(String fi);

    List<Friends> findAllBySurnameContaining(String fi);






}
