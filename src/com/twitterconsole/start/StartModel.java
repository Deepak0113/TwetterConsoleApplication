package com.twitterconsole.start;

public class StartModel implements StartModelCallback {
    StartModelControllerCallback startController;

    StartModel(StartModelControllerCallback startController) {
        this.startController = startController;
    }
}