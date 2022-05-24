package ru.learnup.myproject.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ru.learnup.myproject.socialmedia.entity.Friends;
import ru.learnup.myproject.socialmedia.entity.Posts;
import ru.learnup.myproject.socialmedia.repository.PostsRepository;

import java.util.List;

@Service
public class PostsService {
    @Autowired
    private PostsRepository postsRepository;


    public void newPost(Posts posts) {
        postsRepository.save(posts);
    }

    public List<Posts> showAllPosts() {
        return postsRepository.findAll();
    }


    public List<Posts> findAllByPostContains(String fi) {
        List<Posts> list = postsRepository.findAllByPostContains(fi);
        return list;
    }

}
