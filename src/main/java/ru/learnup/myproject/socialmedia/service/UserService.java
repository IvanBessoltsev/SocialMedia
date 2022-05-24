package ru.learnup.myproject.socialmedia.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import ru.learnup.myproject.socialmedia.dto.UserDTO;
import ru.learnup.myproject.socialmedia.dto.UserDTO2;
import ru.learnup.myproject.socialmedia.entity.User;
import ru.learnup.myproject.socialmedia.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void saveNewUser(User user) {
        userRepository.save(user);
    }


    public User getUserByUsername(String username) {
        User user = null;
        Optional<User> u = userRepository.findByUsername(username);
        if (u.isPresent()) {
            user = u.get();
        }
        return user;
    }


    public List<User> showAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }


    public User checkUser(String username, String password) {
        User user = null;
        Optional<User> u = userRepository.findByUsernameAndAndPassword(username, password);
        if (u.isPresent()) {
            user = u.get();
        }
        return user;
    }

    public List<UserDTO2> findAllBySurnameContains(String fi) {
        List<User> listUser = userRepository.findAllBySurnameContains(fi);
        List<UserDTO2> listDTO = new ArrayList<>();
        for (User u : listUser) {
            UserDTO2 userDTO2 = new UserDTO2(
                    u.getName(),
                    u.getSurname(),
                    u.getPhoneNumber()
            );
            listDTO.add(userDTO2);
        }
        return listDTO;
    }


}



