package com.twitterconsole.viewtweets;

import com.twitterconsole.dto.Post;
import com.twitterconsole.dto.User;
import com.twitterconsole.utility.Validation;

import java.util.List;

public class ViewTweetsController implements ViewTweetsViewControllerCallback, ViewTweetsModelControllerCallback {
    private ViewTweetsViewCallback viewTweetsView;
    private ViewTweetsModelCallback viewTweetsModel;

    ViewTweetsController(ViewTweetsViewCallback viewTweetsView) {
        this.viewTweetsView = viewTweetsView;
        viewTweetsModel = new ViewTweetsModel(this);
    }

    @Override
    public void chooseOption(String option, User user) {
        if(!Validation.validateOption(option)){
            viewTweetsView.invalidOption(user);
        } else{
            switch (option){
                case "1" -> viewTweetsView.viewTweets(user);
                case "2" -> viewTweetsView.gotoHome(user);
                case "3" -> viewTweetsView.gotoStart();
                case "9" -> System.exit(0);
                default -> viewTweetsView.invalidOption(user);
            }
        }
    }

    @Override
    public void viewTweets(User user) {
        viewTweetsModel.viewTweets(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        viewTweetsView.invalidMessage(message, user);
    }

    @Override
    public void tweetsSuccess(List<Post> listPost, User user) {
        viewTweetsView.tweetsSuccess(listPost, user);
    }
}