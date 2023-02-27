package com.twitterconsole.viewfollowers;

import com.twitterconsole.dto.User;
import com.twitterconsole.home.HomeView;
import com.twitterconsole.start.StartView;

import java.util.List;
import java.util.Scanner;

public class ViewFollowersView implements ViewFollowersViewCallback {
    private ViewFollowersViewControllerCallback viewFollowersController;
    private final Scanner scanner = new Scanner(System.in);

    public ViewFollowersView() {
        viewFollowersController = new ViewFollowersController(this);
    }

    public void startViewFollowersView(User user){
        System.out.println("\n1. Continue view follower");
        System.out.println("2. Goto home");
        System.out.println("3. Goto start");
        System.out.println("9. Exit twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        viewFollowersController.chooseOption(option, user);
    }

    @Override
    public void invalidOption(User user) {
        System.out.println("\nInvalid option selected");
        startViewFollowersView(user);
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
    public void viewFollowers(User user) {
        System.out.println("\nView followers");
        System.out.println("------------------------------");

        viewFollowersController.viewFollowers(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        System.out.println(message);
        gotoHome(user);
    }

    @Override
    public void viewFollowersSuccess(List<String> followers, User user) {
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