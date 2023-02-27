package com.twitterconsole.posttweets;

import com.twitterconsole.dto.User;
import com.twitterconsole.utility.Validation;

public class PostTweetsController implements PostTweetsViewControllerCallback, PostTweetsModelControllerCallback {
    private final PostTweetsViewCallback postTweetsView;
    private final PostTweetsModelCallback postTweetsModel;

    PostTweetsController(PostTweetsViewCallback postTweetsView) {
        this.postTweetsView = postTweetsView;
        postTweetsModel = new PostTweetsModel(this);
    }

    @Override
    public void chooseOption(String option, User user) {
        if(!Validation.validateOption(option)){
            postTweetsView.invalidOption(user);
        } else{
            switch (option){
                case "1" -> postTweetsView.postTweet(user);
                case "2" -> postTweetsView.gotoHome(user);
                case "3" -> postTweetsView.gotoStart();
                case "9" -> System.exit(0);
                default -> postTweetsView.invalidOption(user);
            }
        }
    }

    @Override
    public void postTweet(User user, String tweet) {
        postTweetsModel.postTweet(user, tweet);
    }

    @Override
    public void postTweetSuccess(User user) {
        postTweetsView.postTweetSuccess(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        postTweetsView.invalidMessage(message, user);
    }
}