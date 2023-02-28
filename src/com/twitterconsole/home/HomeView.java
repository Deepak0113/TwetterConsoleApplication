package com.twitterconsole.home;

import com.twitterconsole.deletetweet.DeleteTweetView;
import com.twitterconsole.dto.User;
import com.twitterconsole.followuser.FollowUserView;
import com.twitterconsole.posttweets.PostTweetsView;
import com.twitterconsole.viewfollowers.ViewFollowersView;
import com.twitterconsole.viewfollowing.ViewFollowingView;
import com.twitterconsole.viewmytweets.ViewMyTweetsView;
import com.twitterconsole.viewtweets.ViewTweetsView;

import java.util.Scanner;

public class HomeView implements HomeViewCallback {
    private HomeViewControllerCallback homeController;
    private final Scanner scanner = new Scanner(System.in);

    public HomeView() {
        homeController = new HomeController(this);
    }

    /*------ NAVIGATION ------*/
    public void startHome(User user){
        System.out.println("\n1. View tweets");
        System.out.println("2. View my tweets");
        System.out.println("3. Post tweet");
        System.out.println("4. Delete tweet");
        System.out.println("5. Follower user");
        System.out.println("6. View followers");
        System.out.println("7. View following");
        System.out.println("8. Goto home");
        System.out.println("9. Exit twitter");
        System.out.print("Enter option: ");
        String option = scanner.nextLine();

        homeController.chooseOption(option, user);
    }

    @Override
    public void invalidOption(User user) {
        System.out.println("\nInvalid option. Pls choose correct option.");
        startHome(user);
    }

    @Override
    public void gotoViewTweets(User user) {
        new ViewTweetsView().startViewTweetModule(user);
    }

    @Override
    public void gotoViewMyTweets(User user) {
        new ViewMyTweetsView().startViewMyTweetModule(user);
    }

    @Override
    public void gotoPostTweet(User user) {
        new PostTweetsView().startPostTweetModule(user);
    }

    @Override
    public void gotoDeleteTweet(User user) {
        new DeleteTweetView().startDeleteTweetModule(user);
    }

    @Override
    public void gotoFollowUser(User user) {
        new FollowUserView().startFollowUserView(user);
    }

    @Override
    public void gotoViewFollowers(User user) {
        new ViewFollowersView().startViewFollowersView(user);
    }

    @Override
    public void gotoViewFollowing(User user) {
        new ViewFollowingView().startViewFollowingView(user);
    }
}