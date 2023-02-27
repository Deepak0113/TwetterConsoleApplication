package com.twitterconsole.signup;

import com.twitterconsole.repository.Repository;

public class SignupModel implements SignupModelCallback {
    SignupModelControllerCallback signupController;

    SignupModel(SignupModelControllerCallback signupController) {
        this.signupController = signupController;
    }

    @Override
    public void signup(String username, String name, String email, String password, String dob) {
        boolean isSigned = Repository.getInstance().signup(username, name, email, password, dob);
        if(isSigned){
            signupController.signupSuccessful();
        } else{
            signupController.userExist();
        }
    }
}