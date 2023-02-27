package com.twitterconsole.login;

import com.twitterconsole.dto.User;
import com.twitterconsole.home.HomeView;
import com.twitterconsole.start.StartView;

import java.util.Scanner;

public class LoginView implements LoginViewCallback {
    private LoginViewControllerCallback loginController;
    private final Scanner scanner = new Scanner(System.in);

    public LoginView() {
        loginController = new LoginController(this);
    }

    /*------ NAVIGATION ------*/
    public void startLogin(){
        System.out.println("\n1. Continue login");
        System.out.println("2. Goto start");
        System.out.println("9. Exit Twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        loginController.chooseOption(option);
    }

    @Override
    public void gotoStart() {
        new StartView().startStartModule();
    }

    @Override
    public void invalidOption() {
        System.out.println("\nInvalid option. Pls choose correct option.");
        startLogin();
    }

    /*------ LOGIN ------*/
    @Override
    public void login() {
        System.out.println("\nLogin");
        System.out.println("------------------------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        loginController.login(username, password);
    }

    @Override
    public void loginSuccess(User user) {
        System.out.println("\nSuccessfully logged in");
        System.out.println("Hi, " + user.getUsername());

        new HomeView().startHome(user);
    }

    @Override
    public void invalidMessage(String message) {
        System.out.println(message);
        startLogin();
    }
}