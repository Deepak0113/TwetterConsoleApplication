package com.twitterconsole.viewmytweets;

import com.twitterconsole.dto.Post;
import com.twitterconsole.dto.User;
import com.twitterconsole.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViewMyTweetsModel implements ViewMyTweetsModelCallback {
    ViewMyTweetsModelControllerCallback viewMyTweetsController;

    ViewMyTweetsModel(ViewMyTweetsModelControllerCallback viewMyTweetsController) {
        this.viewMyTweetsController = viewMyTweetsController;
    }

    @Override
    public void viewMyTweets(User user) {
        ResultSet resultSet = Repository.getInstance().viewMyTweets(user);
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
            viewMyTweetsController.invalidMessage("\nNo tweets available", user);
        } else{
            viewMyTweetsController.myTweetsSuccess(listPost, user);
        }
    }
}