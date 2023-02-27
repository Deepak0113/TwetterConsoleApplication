package com.twitterconsole.signup;

public interface SignupViewControllerCallback {
    void chooseOption(String option);
    void signup(String username, String name, String email, String password, String dob);
}
