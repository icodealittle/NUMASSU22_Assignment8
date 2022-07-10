package edu.neu.madcourse.numadsu22_a8;

public class UsersInfor {
    private String user;

    public UsersInfor() {
    }

    public UsersInfor(String user) {
        this.user = user;
    }

    public String getName() {
        return this.user;
    }

    public void setName(String username) {
        this.user = username;
    }
}
