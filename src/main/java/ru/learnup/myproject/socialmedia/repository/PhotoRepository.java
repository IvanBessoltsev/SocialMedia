package ru.learnup.myproject.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.myproject.socialmedia.entity.Photo;

import java.util.List;


@Repository
public interface PhotoRepository  extends JpaRepository <Photo,Long>{
    List<Photo> findAllByImageContaining(String fi);

}
