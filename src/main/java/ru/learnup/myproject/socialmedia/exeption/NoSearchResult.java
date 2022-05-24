package ru.learnup.myproject.socialmedia.exeption;

public class NoSearchResult extends  RuntimeException{

    public NoSearchResult () {
        super("Поиск не дал результатов");
    }

}
