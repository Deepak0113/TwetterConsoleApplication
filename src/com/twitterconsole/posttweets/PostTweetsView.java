package com.twitterconsole.posttweets;

import com.twitterconsole.dto.User;
import com.twitterconsole.home.HomeView;
import com.twitterconsole.start.StartView;

import java.util.Scanner;

public class PostTweetsView implements PostTweetsViewCallback {
    private PostTweetsViewControllerCallback postTweetsController;
    private final Scanner scanner = new Scanner(System.in);

    public PostTweetsView() {
        postTweetsController = new PostTweetsController(this);
    }

    /*------ NAVIGATION ------*/
    public void startPostTweetModule(User user){
        System.out.println("\n1. Continue post tweet");
        System.out.println("2. Goto home");
        System.out.println("3. Goto start");
        System.out.println("9. Exit twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        postTweetsController.chooseOption(option, user);
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
    public void invalidOption(User user) {
        System.out.println("\nInvalid option");
        startPostTweetModule(user);
    }


    /*------ POST TWEET ------*/
    @Override
    public void postTweet(User user) {
        System.out.println("\nPost tweet");
        System.out.println("------------------------------");
        System.out.print("Enter your tweet: ");
        String tweet = scanner.nextLine();

        postTweetsController.postTweet(user, tweet);
    }

    @Override
    public void postTweetSuccess(User user) {
        System.out.println("\nSuccessfully posted");
        gotoHome(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        System.out.println(message);
    }
}