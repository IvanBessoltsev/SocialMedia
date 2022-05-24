package ru.learnup.myproject.socialmedia.exeption;

public class IncorrectUpdateProfile extends RuntimeException{

    public IncorrectUpdateProfile ( ) {
        super("Некорректное изменение данных");
    }

}
