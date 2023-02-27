package com.twitterconsole.followuser;

import com.twitterconsole.dto.User;
import com.twitterconsole.home.HomeView;
import com.twitterconsole.start.StartView;

import java.util.Scanner;

public class FollowUserView implements FollowUserViewCallback {
    private final FollowUserViewControllerCallback followUserController;
    private final Scanner scanner = new Scanner(System.in);

    public FollowUserView() {
        followUserController = new FollowUserController(this);
    }

    /*------ NAVIGATION ------*/
    public void startFollowUserView(User user){
        System.out.println("\n1. Continue follow user");
        System.out.println("2. Goto home");
        System.out.println("3. Goto start");
        System.out.println("9. Exit twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        followUserController.chooseOption(option, user);
    }

    @Override
    public void invalidOption(User user) {
        System.out.println("Invalid option selected");
        startFollowUserView(user);
    }

    @Override
    public void gotoHome(User user) {
        new HomeView().startHome(user);
    }

    @Override
    public void gotoStart() {
        new StartView().startStartModule();
    }

    /*------ FOLLOW USER ------*/
    @Override
    public void followUser(User user) {
        System.out.println("\nFollow user");
        System.out.println("------------------------------");
        System.out.print("Enter user id: ");
        String userId = scanner.nextLine();

        followUserController.followUser(user, userId);
    }

    @Override
    public void followUserSuccess(User user, String userId) {
        System.out.println("\nStarted following " + userId);
        gotoHome(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        System.out.println(message);
        gotoHome(user);
    }
}