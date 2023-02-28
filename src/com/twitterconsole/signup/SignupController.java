package com.twitterconsole.signup;

import com.twitterconsole.utility.Validation;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SignupController implements SignupViewControllerCallback, SignupModelControllerCallback {
    private final SignupViewCallback signupView;
    private final SignupModelCallback signupModel;

    SignupController(SignupViewCallback signupView) {
        this.signupView = signupView;
        signupModel = new SignupModel(this);
    }

    /*------ NAVIGATION ------*/
    @Override
    public void chooseOption(String option) {
        if(!Validation.validateOption(option)){
            signupView.invalidOption();
        } else{
            switch (option){
                case "1" -> signupView.signup();
                case "2" -> signupView.gotoStart();
                case "9" -> System.exit(0);
                default -> signupView.invalidOption();
            }
        }
    }

    /*------ SIGN UP ------*/
    @Override
    public void signup(String username, String name, String email, String password, String dob) {
        if(!Validation.validateName(username)){
            signupView.invalidMessage("\nInvalid username");
            return;
        }
        if(!Validation.validateName(name)){
            signupView.invalidMessage("\nInvalid name");
            return;
        }
//        if(!Validation.validateEmail(email)){
//            signupView.invalidMessage("\nInvalid email");
//            return;
//        }
//        if(!Validation.validatePassword(password)){
//            System.out.println("\nInvalid password");
//            return;
//        }
        signupModel.signup(username, name, email, password, dob);
    }

    @Override
    public void invalidMessage(String message) {
        signupView.invalidMessage("\n" + message);
    }

    @Override
    public void signupSuccessful() {
        signupView.signupSuccessful();
    }
}