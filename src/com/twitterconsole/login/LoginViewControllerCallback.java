package com.twitterconsole.login;

public interface LoginViewControllerCallback {
    void chooseOption(String option);
    void login(String username, String password);
}
