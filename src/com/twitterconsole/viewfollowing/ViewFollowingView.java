package com.twitterconsole.viewfollowing;

import com.twitterconsole.dto.User;
import com.twitterconsole.home.HomeView;
import com.twitterconsole.start.StartView;

import java.util.List;
import java.util.Scanner;

public class ViewFollowingView implements ViewFollowingViewCallback {
    private ViewFollowingViewControllerCallback viewFollowingController;
    private final Scanner scanner = new Scanner(System.in);

    public ViewFollowingView() {
        viewFollowingController = new ViewFollowingController(this);
    }

    public void startViewFollowingView(User user){
        System.out.println("\n1. Continue view following");
        System.out.println("2. Goto home");
        System.out.println("3. Goto start");
        System.out.println("9. Exit twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        viewFollowingController.chooseOption(option, user);
    }

    @Override
    public void invalidOption(User user) {
        System.out.println("\nInvalid option selected");
        startViewFollowingView(user);
    }

    @Override
    public void gotoHome(User user) {
        new HomeView().startHome(user);
    }

    @Override
    public void gotoStart() {
        new StartView().startStartModule();
    }

    @Override
    public void viewFollowing(User user) {
        System.out.println("\nView following");
        System.out.println("------------------------------");

        viewFollowingController.viewFollowing(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        System.out.println(message);
        gotoHome(user);
    }

    @Override
    public void viewFollowingSuccess(List<String> followers, User user) {
        int count = 1;
        for(String follower: followers){
            System.out.print(follower+" ");
            if(count%10==0){
                System.out.println();
            }
            count++;
        }
        gotoHome(user);
    }
}