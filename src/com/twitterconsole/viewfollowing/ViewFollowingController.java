package com.twitterconsole.viewfollowing;

import com.twitterconsole.dto.User;
import com.twitterconsole.utility.Validation;

import java.util.List;

public class ViewFollowingController implements ViewFollowingViewControllerCallback, ViewFollowingModelControllerCallback {
    private ViewFollowingViewCallback viewFollowingView;
    private ViewFollowingModelCallback viewFollowingModel;

    ViewFollowingController(ViewFollowingViewCallback viewFollowingView) {
        this.viewFollowingView = viewFollowingView;
        viewFollowingModel = new ViewFollowingModel(this);
    }

    @Override
    public void chooseOption(String option, User user) {
        if(!Validation.validateOption(option)){
            viewFollowingView.invalidOption(user);
        } else{
            switch (option){
                case "1" -> viewFollowingView.viewFollowing(user);
                case "2" -> viewFollowingView.gotoHome(user);
                case "3" -> viewFollowingView.gotoStart();
                case "9" -> System.exit(0);
                default -> viewFollowingView.invalidOption(user);
            }
        }
    }

    @Override
    public void viewFollowing(User user) {
        viewFollowingModel.viewFollowing(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        viewFollowingView.invalidMessage(message, user);
    }

    @Override
    public void viewFollowersSuccess(List<String> followers, User user) {
        viewFollowingView.viewFollowingSuccess(followers, user);
    }
}