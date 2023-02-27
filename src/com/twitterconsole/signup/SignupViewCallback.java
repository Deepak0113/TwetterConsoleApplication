package com.twitterconsole.signup;

public interface SignupViewCallback {
    void invalidOption();
    void signup();
    void gotoStart();
    void invalidMessage(String s);
    void signupSuccessful();
}