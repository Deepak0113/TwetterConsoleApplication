package com.twitterconsole.viewfollowers;

import com.twitterconsole.dto.User;
import com.twitterconsole.utility.Validation;

import java.util.List;

public class ViewFollowersController implements ViewFollowersViewControllerCallback, ViewFollowersModelControllerCallback {
    private ViewFollowersViewCallback viewFollowersView;
    private ViewFollowersModelCallback viewFollowersModel;

    ViewFollowersController(ViewFollowersViewCallback viewFollowersView) {
        this.viewFollowersView = viewFollowersView;
        viewFollowersModel = new ViewFollowersModel(this);
    }

    @Override
    public void chooseOption(String option, User user) {
        if(!Validation.validateOption(option)){
            viewFollowersView.invalidOption(user);
        } else{
            switch (option){
                case "1" -> viewFollowersView.viewFollowers(user);
                case "2" -> viewFollowersView.gotoHome(user);
                case "3" -> viewFollowersView.gotoStart();
                case "9" -> System.exit(0);
                default -> viewFollowersView.invalidOption(user);
            }
        }
    }

    @Override
    public void viewFollowers(User user) {
        viewFollowersModel.viewFollowers(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        viewFollowersView.invalidMessage(message, user);
    }

    @Override
    public void viewFollowersSuccess(List<String> followers, User user) {
        viewFollowersView.viewFollowersSuccess(followers, user);
    }
}