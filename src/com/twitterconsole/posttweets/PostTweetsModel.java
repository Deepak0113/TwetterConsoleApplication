package com.twitterconsole.posttweets;

import com.twitterconsole.dto.User;
import com.twitterconsole.repository.Repository;

public class PostTweetsModel implements PostTweetsModelCallback {
    PostTweetsModelControllerCallback postTweetsController;

    PostTweetsModel(PostTweetsModelControllerCallback postTweetsController) {
        this.postTweetsController = postTweetsController;
    }

    @Override
    public void postTweet(User user, String tweet) {
        boolean isPosted = Repository.getInstance().postTweet(user, tweet);
        if(isPosted){
            postTweetsController.postTweetSuccess(user);
        } else{
            postTweetsController.invalidMessage("\nTweet failed for unknown reasons", user);
        }
    }
}