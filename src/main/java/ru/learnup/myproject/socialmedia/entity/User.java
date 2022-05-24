package ru.learnup.myproject.socialmedia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birth_date")
    private String date;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private List<Posts> posts;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private List<Friends> friends;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private List<Message> messages;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "users_id")
    private List<Photo> Image;



}
