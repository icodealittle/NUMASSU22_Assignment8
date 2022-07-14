package edu.neu.madcourse.numadsu22_a8;

import java.io.Serializable;


public class User implements Serializable {

    public String username;
    public int stickerNum;
    public String token;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String token) {
        this.username = username;
        this.stickerNum = 0;
        this.token = token;
    }

}

