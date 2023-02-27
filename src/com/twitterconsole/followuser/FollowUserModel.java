package com.twitterconsole.followuser;

import com.twitterconsole.StatusCalls.FollowUserStatusCall;
import com.twitterconsole.StatusCalls.UserStatusCall;
import com.twitterconsole.dto.User;
import com.twitterconsole.repository.Repository;

public class FollowUserModel implements FollowUserModelCallback {
    FollowUserModelControllerCallback followUserController;

    FollowUserModel(FollowUserModelControllerCallback followUserController) {
        this.followUserController = followUserController;
    }

    @Override
    public void followUser(User user, String userId) {
        FollowUserStatusCall followUserStatusCall = Repository.getInstance().followUser(user, userId);
        switch (followUserStatusCall.getStatus()){
            case "SUCCESS" -> followUserController.followUserSuccess(user, userId);
            case "NOT EXIST" -> followUserController.invalidMessage("\nUser not exists", user);
            case "FOLLOWING" -> followUserController.invalidMessage("\nYou are already following " + userId, user);
        }
    }
}