package ru.luxtington.oop.different.animals.birds;

import ru.luxtington.oop.different.RandomHelper;

public class Parrot extends Bird{

    private String songText;

    public Parrot(String songText){
        setSongText(songText);
    }

    public String getSongText(){
        return songText;
    }

    public void setSongText(String songText){
        if (songText.isBlank())
            throw new IllegalArgumentException("Incorrect value of song's text for bird");
        this.songText = songText;
    }

    @Override
    public void sing(){
        System.out.println(RandomHelper.swapLetters(songText));
    }
}
