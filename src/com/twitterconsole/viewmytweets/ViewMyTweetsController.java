package com.twitterconsole.viewmytweets;

import com.twitterconsole.dto.Post;
import com.twitterconsole.dto.User;
import com.twitterconsole.utility.Validation;

import java.util.List;

public class ViewMyTweetsController implements ViewMyTweetsViewControllerCallback, ViewMyTweetsModelControllerCallback {
    private ViewMyTweetsViewCallback viewMyTweetsView;
    private ViewMyTweetsModelCallback viewMyTweetsModel;

    ViewMyTweetsController(ViewMyTweetsViewCallback viewMyTweetsView) {
        this.viewMyTweetsView = viewMyTweetsView;
        viewMyTweetsModel = new ViewMyTweetsModel(this);
    }

    @Override
    public void chooseOption(String option, User user) {
        if(!Validation.validateOption(option)){
            viewMyTweetsView.invalidOption(user);
        } else{
            switch (option){
                case "1" -> viewMyTweetsView.viewMyTweets(user);
                case "2" -> viewMyTweetsView.gotoHome(user);
                case "3" -> viewMyTweetsView.gotoStart();
                case "9" -> System.exit(0);
                default -> viewMyTweetsView.invalidOption(user);
            }
        }
    }

    @Override
    public void viewMyTweets(User user) {
        viewMyTweetsModel.viewMyTweets(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        viewMyTweetsView.invalidMessage(message, user);
    }

    @Override
    public void myTweetsSuccess(List<Post> listPost, User user) {
        viewMyTweetsView.myTweetsSuccess(listPost, user);
    }
}