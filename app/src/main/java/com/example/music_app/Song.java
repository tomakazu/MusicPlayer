package com.example.music_app;

public class Song {

    String title,author,song_Url;

    public Song() {
    }

    public Song(String title, String author, String song_Url) {
        this.title = title;
        this.author = author;
        this.song_Url = song_Url;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getSong_Url() {
        return song_Url;
    }
}
