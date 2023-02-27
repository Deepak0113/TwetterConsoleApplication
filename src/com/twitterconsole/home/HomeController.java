package com.twitterconsole.home;

import com.twitterconsole.dto.User;
import com.twitterconsole.utility.Validation;

public class HomeController implements HomeViewControllerCallback, HomeModelControllerCallback {
    private HomeViewCallback homeView;
    private HomeModelCallback homeModel;

    HomeController(HomeViewCallback homeView) {
        this.homeView = homeView;
        homeModel = new HomeModel(this);
    }

    @Override
    public void chooseOption(String option, User user) {
        if(!Validation.validateOption(option)){
            homeView.invalidOption(user);
        } else{
            switch (option){
                case "1" -> homeView.gotoViewTweets(user);
                case "2" -> homeView.gotoViewMyTweets(user);
                case "3" -> homeView.gotoPostTweet(user);
                case "4" -> homeView.gotoDeleteTweet(user);
                case "5" -> homeView.gotoFollowUser(user);
                case "6" -> homeView.gotoViewFollowers(user);
                case "7" -> homeView.gotoViewFollowing(user);
                case "9" -> System.exit(0);
                default -> homeView.invalidOption(user);
            }
        }
    }
}