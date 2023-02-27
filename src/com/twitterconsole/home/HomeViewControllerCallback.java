package com.twitterconsole.home;

import com.twitterconsole.dto.User;

public interface HomeViewControllerCallback {
    void chooseOption(String option, User user);
}
