package com.twitterconsole.viewmytweets;

import com.twitterconsole.dto.Post;
import com.twitterconsole.dto.User;
import com.twitterconsole.home.HomeView;
import com.twitterconsole.start.StartView;

import java.util.List;
import java.util.Scanner;

public class ViewMyTweetsView implements ViewMyTweetsViewCallback {
    private final ViewMyTweetsViewControllerCallback viewMyTweetsController;
    private final Scanner scanner = new Scanner(System.in);

    public ViewMyTweetsView() {
        viewMyTweetsController = new ViewMyTweetsController(this);
    }

    public void startViewMyTweetModule(User user){
        System.out.println("\n1. Continue view tweets");
        System.out.println("2. Goto home");
        System.out.println("3. Goto start");
        System.out.println("9. Exit twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        viewMyTweetsController.chooseOption(option, user);
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
        startViewMyTweetModule(user);
    }

    @Override
    public void viewMyTweets(User user) {
        viewMyTweetsController.viewMyTweets(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        System.out.println(message);
        gotoHome(user);
    }

    @Override
    public void myTweetsSuccess(List<Post> listPost, User user) {
        System.out.println("\nMy tweets");
        System.out.println("------------------------------");
        for (Post post: listPost){
            System.out.println(post);
        }
        gotoHome(user);
    }
}