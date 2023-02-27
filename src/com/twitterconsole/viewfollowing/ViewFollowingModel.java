package com.twitterconsole.viewfollowing;

import com.twitterconsole.dto.User;
import com.twitterconsole.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewFollowingModel implements ViewFollowingModelCallback {
    ViewFollowingModelControllerCallback viewFollowingController;

    ViewFollowingModel(ViewFollowingModelControllerCallback viewFollowingController) {
        this.viewFollowingController = viewFollowingController;
    }

    @Override
    public void viewFollowing(User user) {
        ResultSet resultSet = Repository.getInstance().viewFollowing(user);

        List<String> followers = new ArrayList<>();
        try{
            while(resultSet.next()){
                followers.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(followers.size() == 0){
            viewFollowingController.invalidMessage("There are no followers", user);
        } else {
            viewFollowingController.viewFollowersSuccess(followers, user);
        }
    }
}