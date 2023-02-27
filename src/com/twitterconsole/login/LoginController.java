package com.twitterconsole.login;

import com.twitterconsole.dto.User;
import com.twitterconsole.utility.Validation;

public class LoginController implements LoginViewControllerCallback, LoginModelControllerCallback {
    private LoginViewCallback loginView;
    private LoginModelCallback loginModel;

    LoginController(LoginViewCallback loginView) {
        this.loginView = loginView;
        loginModel = new LoginModel(this);
    }

    /*------ NAVIGATION ------*/
    @Override
    public void chooseOption(String option) {
        if(!Validation.validateOption(option)){
            loginView.invalidOption();
        } else{
            switch (option){
                case "1" -> loginView.login();
                case "2" -> loginView.gotoStart();
                case "9" -> System.exit(0);
                default -> loginView.invalidOption();
            }
        }
    }

    /*------ LOGIN ------*/
    @Override
    public void login(String username, String password) {
        loginModel.login(username, password);
    }

    @Override
    public void loginSuccess(User user) {
        loginView.loginSuccess(user);
    }

    @Override
    public void invalidMessage(String message) {
        loginView.invalidMessage(message);
    }
}