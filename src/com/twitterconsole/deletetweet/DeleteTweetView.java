package com.twitterconsole.deletetweet;

import com.twitterconsole.dto.User;
import com.twitterconsole.home.HomeView;
import com.twitterconsole.start.StartView;

import java.util.Scanner;

public class DeleteTweetView implements DeleteTweetViewCallback {
    private DeleteTweetViewControllerCallback deleteTweetController;
    private final Scanner scanner = new Scanner(System.in);

    public DeleteTweetView() {
        deleteTweetController = new DeleteTweetController(this);
    }

    /*------ NAVIGATION ------*/
    public void startDeleteTweetModule(User user){
        System.out.println("\n1. Continue delete tweet");
        System.out.println("2. Goto home");
        System.out.println("3. Goto start");
        System.out.println("9. Exit twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        deleteTweetController.chooseOption(option, user);
    }

    @Override
    public void invalidOption(User user) {
        System.out.println("\nInvalid option");
        startDeleteTweetModule(user);
    }

    @Override
    public void gotoHome(User user) {
        new HomeView().startHome(user);
    }

    @Override
    public void gotoStart() {
        new StartView().startStartModule();
    }

    /*------ DELETE TWEET ------*/

    @Override
    public void deleteTweet(User user) {
        System.out.println("Delete tweet");
        System.out.println("------------------------------");
        System.out.print("\nEnter tweet id: ");
        String tweetId = scanner.nextLine();
        deleteTweetController.deleteTweet(user, tweetId);
    }

    @Override
    public void invalidMessage(String message, User user) {
        System.out.println(message);
        gotoHome(user);
    }

    @Override
    public void deleteTweetSuccessfully(User user) {
        System.out.println("\nDeleted successfully");
        gotoHome(user);
    }
}