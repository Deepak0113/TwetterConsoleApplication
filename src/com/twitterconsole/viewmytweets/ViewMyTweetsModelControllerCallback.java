package com.twitterconsole.viewmytweets;

import com.twitterconsole.dto.Post;
import com.twitterconsole.dto.User;

import java.util.List;

public interface ViewMyTweetsModelControllerCallback {
    void invalidMessage(String s, User user);
    void myTweetsSuccess(List<Post> listPost, User user);
}
