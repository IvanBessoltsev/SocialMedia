package ru.learnup.myproject.socialmedia.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO2 {
    private String name;
    private String surname;
    private String phoneNumber;
}
