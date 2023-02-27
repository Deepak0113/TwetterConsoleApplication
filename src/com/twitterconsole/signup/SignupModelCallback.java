package com.twitterconsole.signup;

public interface SignupModelCallback {
    void signup(String username, String name, String email, String password, String dob);
}