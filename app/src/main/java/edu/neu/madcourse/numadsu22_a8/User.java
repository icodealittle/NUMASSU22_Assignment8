package edu.neu.madcourse.numadsu22_a8;

import com.google.firebase.installations.Utils;

import java.time.LocalDateTime;


public class User {

    public String username;
    public int stickerNum;
    public String datePlayed;


    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, int stickerNum) {
        this.username = username;
        this.stickerNum = stickerNum;
        this.datePlayed = LocalDateTime.now().toString();
    }


    public User(String username, int stickerNum, String date) {
        this.username = username;
        this.stickerNum = stickerNum;
        this.datePlayed = date;
    }

}

