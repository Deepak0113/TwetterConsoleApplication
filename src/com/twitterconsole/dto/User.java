package com.twitterconsole.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class User {
    private String username;
    private String passwordHash;
    private String name;
    private String email;
    private Date dob;
    private Timestamp joinedDate;

    public User(String username, String passwordHash, String name, String email, Date dob, Timestamp joinedDate) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.joinedDate = joinedDate;
    }

    public String getUsername() {
        return username;
    }
}
