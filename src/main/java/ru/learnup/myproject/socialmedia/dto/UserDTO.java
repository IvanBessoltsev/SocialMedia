package ru.learnup.myproject.socialmedia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.learnup.myproject.socialmedia.entity.Posts;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String name;
    private String surname;
    private String date;
    private String phoneNumber;
    private List<Posts> posts;

}
