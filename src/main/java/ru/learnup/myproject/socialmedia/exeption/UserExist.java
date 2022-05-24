package ru.learnup.myproject.socialmedia.exeption;

public class UserExist extends RuntimeException{



    public UserExist ( ) {
        super("Пользователь с таким именем уже существует");
    }
}
