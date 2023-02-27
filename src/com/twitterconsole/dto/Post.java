package com.twitterconsole.dto;

import java.sql.Timestamp;

public class Post {
    private String postId;
    private String username;
    private String postText;
    private Timestamp timestamp;

    public Post(String postId, String username, String postText, Timestamp timestamp) {
        this.postId = postId;
        this.username = username;
        this.postText = postText;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        String res = "\n--------------------------------------------------\n";
        res += username + "\t(Tweet id: " + this.postId + ")";
        res += "\n--------------------------------------------------\n";
        res += postText;

        return res;
    }
}
