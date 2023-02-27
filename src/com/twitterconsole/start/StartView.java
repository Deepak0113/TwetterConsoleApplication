package com.twitterconsole.start;

import com.twitterconsole.login.LoginView;
import com.twitterconsole.signup.SignupView;

import java.util.Scanner;

public class StartView implements StartViewCallback {
    private StartViewControllerCallback startController;
    private final Scanner scanner = new Scanner(System.in);

    public StartView() {
        startController = new StartController(this);
    }

    public void startStartModule(){
        System.out.println("\nTwitter");
        System.out.println("------------------------------");
        System.out.println("1. Login");
        System.out.println("2. Signup");
        System.out.println("9. Exit twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        startController.chooseOption(option);
    }

    @Override
    public void invalidOption() {
        System.out.println("\nInvalid option. Pls choose correct option.");
        startStartModule();
    }

    @Override
    public void gotoLogin() {
        new LoginView().startLogin();
    }

    @Override
    public void gotoSignup() {
        new SignupView().startSignup();
    }
}