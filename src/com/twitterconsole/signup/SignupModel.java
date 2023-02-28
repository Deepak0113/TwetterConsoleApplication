package com.twitterconsole.signup;

import com.twitterconsole.StatusCalls.UserStatusCall;
import com.twitterconsole.repository.Repository;

public class SignupModel implements SignupModelCallback {
    SignupModelControllerCallback signupController;

    SignupModel(SignupModelControllerCallback signupController) {
        this.signupController = signupController;
    }

    @Override
    public void signup(String username, String name, String email, String password, String dob) {
        UserStatusCall userStatusCall = Repository.getInstance().signup(username, name, email, password, dob);
        switch (userStatusCall.getStatus()){
            case "SUCCESS" -> signupController.signupSuccessful();
            case "USER EXIST" -> signupController.invalidMessage("User already exist.");
            case "EMAIL EXIST" -> signupController.invalidMessage("Email already exist.");
        }
    }
}