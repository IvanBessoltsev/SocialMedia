package ru.learnup.myproject.socialmedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import ru.learnup.myproject.socialmedia.entity.Friends;
import ru.learnup.myproject.socialmedia.repository.FriendsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendsService {
    private FriendsRepository friendsRepository;

    @Autowired
    public FriendsService(FriendsRepository friendsRepository) {
        this.friendsRepository = friendsRepository;
    }


    public List<Friends> nameFriends(String fi) {
        List<Friends> listName = friendsRepository.findAllByNameContaining(fi);
        return listName;
    }


    public List<Friends> surnameFriends(String fi) {
        List<Friends> listSurname = friendsRepository.findAllBySurnameContaining(fi);
        return listSurname;
    }


}
