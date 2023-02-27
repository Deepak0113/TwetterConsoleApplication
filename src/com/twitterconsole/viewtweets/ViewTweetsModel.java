package com.twitterconsole.viewtweets;

import com.twitterconsole.dto.Post;
import com.twitterconsole.dto.User;
import com.twitterconsole.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewTweetsModel implements ViewTweetsModelCallback {
    ViewTweetsModelControllerCallback viewTweetsController;

    ViewTweetsModel(ViewTweetsModelControllerCallback viewTweetsController) {
        this.viewTweetsController = viewTweetsController;
    }

    @Override
    public void viewTweets(User user) {
        ResultSet resultSet = Repository.getInstance().viewTweets(user);
        int count = 0;
        List<Post> listPost = new ArrayList<>();

        try {
            while(resultSet.next()){
                listPost.add(new Post(
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getTimestamp(4)
                ));
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(count == 0){
            viewTweetsController.invalidMessage("\nNo tweets available", user);
        } else{
            viewTweetsController.tweetsSuccess(listPost, user);
        }
    }
}