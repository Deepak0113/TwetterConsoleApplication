package com.twitterconsole.deletetweet;

import com.twitterconsole.dto.User;
import com.twitterconsole.repository.Repository;

public class DeleteTweetModel implements DeleteTweetModelCallback {
    DeleteTweetModelControllerCallback deleteTweetController;

    DeleteTweetModel(DeleteTweetModelControllerCallback deleteTweetController) {
        this.deleteTweetController = deleteTweetController;
    }

    @Override
    public void deleteTweet(User user, String tweetId) {
        boolean isDeleted = Repository.getInstance().deleteTweet(user, tweetId);

        if(isDeleted){
            deleteTweetController.deleteTweetSuccessfully(user);
        } else{
            deleteTweetController.invalidMessage("\nTweet not found", user);
        }
    }
}