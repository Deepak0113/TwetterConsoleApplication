package com.twitterconsole.signup;

public interface SignupModelControllerCallback {
    void invalidMessage(String message);
    void signupSuccessful();
}
