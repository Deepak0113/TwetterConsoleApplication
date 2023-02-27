package com.twitterconsole.viewtweets;

import com.twitterconsole.dto.Post;
import com.twitterconsole.dto.User;

import java.util.List;

public interface ViewTweetsModelControllerCallback {
    void invalidMessage(String s, User user);
    void tweetsSuccess(List<Post> listPost, User user);
}
