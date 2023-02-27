package com.twitterconsole.viewtweets;

import com.twitterconsole.dto.Post;
import com.twitterconsole.dto.User;
import com.twitterconsole.home.HomeView;
import com.twitterconsole.start.StartView;

import java.util.List;
import java.util.Scanner;

public class ViewTweetsView implements ViewTweetsViewCallback {
    private ViewTweetsViewControllerCallback viewTweetsController;
    private final Scanner scanner = new Scanner(System.in);

    public ViewTweetsView() {
        viewTweetsController = new ViewTweetsController(this);
    }

    public void startViewTweetModule(User user){
        System.out.println("\n1. Continue view my tweet");
        System.out.println("2. Goto home");
        System.out.println("3. Goto start");
        System.out.println("9. Exit twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        viewTweetsController.chooseOption(option, user);
    }

    @Override
    public void invalidOption(User user) {
        System.out.println("\nInvalid option");
        startViewTweetModule(user);
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
    public void viewTweets(User user) {
        System.out.println("\nView tweets");
        System.out.println("------------------------------");
        viewTweetsController.viewTweets(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        System.out.println(message);
        gotoHome(user);
    }

    @Override
    public void tweetsSuccess(List<Post> listPost, User user) {
        for (Post post: listPost){
            System.out.println(post);
        }
        gotoHome(user);
    }
}