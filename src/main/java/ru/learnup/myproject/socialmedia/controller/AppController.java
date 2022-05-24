package ru.learnup.myproject.socialmedia.controller;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.learnup.myproject.socialmedia.dto.UserDTO;
import ru.learnup.myproject.socialmedia.entity.*;
import ru.learnup.myproject.socialmedia.exeption.IncorrectUpdateProfile;
import ru.learnup.myproject.socialmedia.exeption.NoSearchResult;
import ru.learnup.myproject.socialmedia.exeption.UserExist;
import ru.learnup.myproject.socialmedia.service.*;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping({"/"})
public class AppController {

    private UserService userService;
    private PostsService postsService;
    private NewsService newsService;
    private FriendsService friendsService;
    private MessageService messageService;
    private PhotoService photoService;


    @Autowired
    public AppController(UserService userService,
                         PostsService postsService,
                         NewsService newsService,
                         FriendsService friendsService,
                         MessageService messageService,
                         PhotoService photoService) {
        this.userService = userService;
        this.postsService = postsService;
        this.newsService = newsService;
        this.friendsService = friendsService;
        this.messageService = messageService;
        this.photoService = photoService;
            }



    //***Registration
    @Transactional
    @PostMapping({"/reg"})
    public void saveClient(@RequestBody User user, HttpServletResponse resp) {
        if (userService.getUserByUsername(user.getUsername()) == null) {
            userService.saveNewUser(user);
        } else {
            throw new UserExist();
        }
        try {
            resp.sendRedirect("http://localhost:8189/api/welcome");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //profile->profile/id
    @GetMapping({"/profile"})
    public void getClient(Principal principal, HttpServletResponse resp) {
        String namePrincipal = principal.getName();
        User user = userService.getUserByUsername(namePrincipal);
        try {
            resp.sendRedirect("/profile/" + user.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping({"/profile/{id}"})
    public UserDTO getClient(@PathVariable long id, Principal principal) {
        String namePrincipal = principal.getName();
        User user = userService.getUserByUsername(namePrincipal);
        UserDTO userDTO = new UserDTO
                (user.getName(),
                        user.getSurname(),
                        user.getDate(),
                        user.getPhoneNumber(),
                        user.getPosts());
        return userDTO;
    }

    //***photo
    @GetMapping({"/photo"})
    public void getAllPhoto(Principal principal) throws IOException {
        String namePrincipal = principal.getName();
        User user = userService.getUserByUsername(namePrincipal);
        List<Photo> photos = user.getImage();
        for (Photo p : photos) {
            try {
                BufferedImage image = ImageIO.read(new File(p.getImage()));
                ImageIO.write(image, "jpg", new File("tiger.jpg"));
            } catch (IOException e) {
                throw new IOException("Фото не найдены");
            }
        }
    }

    //***message
    @GetMapping({"/message"})
    public List<Message> getAllMessage(Principal principal) throws IOException {
        String namePrincipal = principal.getName();
        User user = userService.getUserByUsername(namePrincipal);
        List<Message> messages = user.getMessages();
        return messages;
    }

    //***friends
    @GetMapping({"/friends"})
    public List<Friends> getAllFriends(Principal principal) throws IOException {
        String namePrincipal = principal.getName();
        User user = userService.getUserByUsername(namePrincipal);
        List<Friends> friends = user.getFriends();
        return friends;
    }

    //***news
    @GetMapping({"/news"})
    public List<News> showAllNews() {
        List<News> news = newsService.showAllNews();
        return news;
    }

    //*** search
    @GetMapping({"/search"})
    public List search(@RequestParam(name = "find") String find) {
        try {
            List result = Arrays.asList(
                    newsService.findAllByNewsContains(find),
                    postsService.findAllByPostContains(find),
                    friendsService.nameFriends(find),
                    friendsService.surnameFriends(find),
                    messageService.findAllByMessageContaining(find),
                    photoService.findAllByImageContaining(find),
                    userService.findAllBySurnameContains(find)
            );
            return result;
        } catch (RuntimeException e) {
            throw new NoSearchResult();
        }

    }


    @PutMapping("/updateProfile")
    public String updateUser(@RequestBody User user, Principal principal) {
        String namePrincipal = principal.getName();
        User userDB = userService.getUserByUsername(namePrincipal);
        try {
            if (userDB.getId() == user.getId()) {
                userDB.setName(user.getName());
                userDB.setSurname(user.getSurname());
                userDB.setPhoneNumber(user.getPhoneNumber());
                userDB.setDate(user.getDate());
                userService.saveNewUser(userDB);
            }
            return "Изменение данных прошло успешно";
        } catch (RuntimeException e) {
            throw new IncorrectUpdateProfile();
        }


    }


}