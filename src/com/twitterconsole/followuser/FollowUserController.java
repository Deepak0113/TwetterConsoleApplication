package com.twitterconsole.followuser;

import com.twitterconsole.dto.User;
import com.twitterconsole.utility.Validation;

public class FollowUserController implements FollowUserViewControllerCallback, FollowUserModelControllerCallback {
    private FollowUserViewCallback followUserView;
    private FollowUserModelCallback followUserModel;

    FollowUserController(FollowUserViewCallback followUserView) {
        this.followUserView = followUserView;
        followUserModel = new FollowUserModel(this);
    }

    /*------ NAVIGATION ------*/
    @Override
    public void chooseOption(String option, User user) {
        if(!Validation.validateOption(option)){
            followUserView.invalidOption(user);
        } else{
            switch (option){
                case "1" -> followUserView.followUser(user);
                case "2" -> followUserView.gotoHome(user);
                case "3" -> followUserView.gotoStart();
                case "9" -> System.exit(0);
                default -> followUserView.invalidOption(user);
            }
        }
    }

    /*------ FOLLOW USER -------*/
    @Override
    public void followUser(User user, String userId) {
        followUserModel.followUser(user, userId);
    }

    @Override
    public void followUserSuccess(User user, String userId) {
        followUserView.followUserSuccess(user, userId);
    }

    @Override
    public void invalidMessage(String message, User user) {
        followUserView.invalidMessage(message, user);
    }
}