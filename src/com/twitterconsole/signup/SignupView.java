package com.twitterconsole.signup;

import com.twitterconsole.start.StartView;

import java.util.Scanner;

public class SignupView implements SignupViewCallback {
    private final SignupViewControllerCallback signupController;
    private final Scanner scanner = new Scanner(System.in);

    public SignupView() {
        signupController = new SignupController(this);
    }

    /*------ NAVIGATION ------*/
    public void startSignup(){
        System.out.println("\n1. Continue signup");
        System.out.println("2. Goto start");
        System.out.println("9. Exit Twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        signupController.chooseOption(option);
    }

    @Override
    public void gotoStart() {
        new StartView().startStartModule();
    }

    @Override
    public void invalidOption() {
        System.out.println("\nInvalid option. Pls choose correct option.");
        startSignup();
    }

    /*------ SIGNUP ------*/
    @Override
    public void signup() {
        System.out.println("\nSign up");
        System.out.println("------------------------------");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.print("Enter your date of birth (yyyy/mm/dd): ");
        String dob = scanner.nextLine();

        signupController.signup(username, name, email, password, dob);
    }

    @Override
    public void invalidMessage(String message) {
        System.out.println(message);
        startSignup();
    }

    @Override
    public void signupSuccessful() {
        System.out.println("\nSigned up successfully. Login to continue");
        new StartView().startStartModule();
    }
}