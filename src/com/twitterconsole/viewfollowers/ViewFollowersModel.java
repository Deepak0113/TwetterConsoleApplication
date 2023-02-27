package com.twitterconsole.viewfollowers;

import com.twitterconsole.dto.User;
import com.twitterconsole.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewFollowersModel implements ViewFollowersModelCallback {
    ViewFollowersModelControllerCallback viewFollowersController;

    ViewFollowersModel(ViewFollowersModelControllerCallback viewFollowersController) {
        this.viewFollowersController = viewFollowersController;
    }

    @Override
    public void viewFollowers(User user) {
        ResultSet resultSet = Repository.getInstance().viewFollower(user);

        List<String> followers = new ArrayList<>();
        try{
            while(resultSet.next()){
                followers.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(followers.size() == 0){
            viewFollowersController.invalidMessage("There are no followers", user);
        } else {
            viewFollowersController.viewFollowersSuccess(followers, user);
        }
    }
}