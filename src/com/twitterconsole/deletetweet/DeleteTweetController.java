package com.twitterconsole.deletetweet;

import com.twitterconsole.dto.User;
import com.twitterconsole.utility.Validation;

public class DeleteTweetController implements DeleteTweetViewControllerCallback, DeleteTweetModelControllerCallback {
    private DeleteTweetViewCallback deleteTweetView;
    private DeleteTweetModelCallback deleteTweetModel;

    DeleteTweetController(DeleteTweetViewCallback deleteTweetView) {
        this.deleteTweetView = deleteTweetView;
        deleteTweetModel = new DeleteTweetModel(this);
    }

    @Override
    public void chooseOption(String option, User user) {
        if(!Validation.validateOption(option)){
            deleteTweetView.invalidOption(user);
        } else{
            switch (option){
                case "1" -> deleteTweetView.deleteTweet(user);
                case "2" -> deleteTweetView.gotoHome(user);
                case "3" -> deleteTweetView.gotoStart();
                case "9" -> System.exit(0);
                default -> deleteTweetView.invalidOption(user);
            }
        }
    }

    @Override
    public void deleteTweet(User user, String tweetId) {
        deleteTweetModel.deleteTweet(user, tweetId);
    }

    @Override
    public void deleteTweetSuccessfully(User user) {
        deleteTweetView.deleteTweetSuccessfully(user);
    }

    @Override
    public void invalidMessage(String message, User user) {
        deleteTweetView.invalidMessage(message, user);
    }
}