package edu.neu.madcourse.numadsu22_a8.history;

public class ChatHistory {
    public String sender;
    public String date;
    public int message; // replace it with image

    public ChatHistory() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public ChatHistory(String sender, String date, int message) {
        this.sender = sender;
        this.date = date;
        this.message = message;
    }
}
