package com.twitterconsole.start;

import com.twitterconsole.utility.Validation;

public class StartController implements StartViewControllerCallback, StartModelControllerCallback {
    private StartViewCallback startView;
    private StartModelCallback startModel;

    StartController(StartViewCallback startView) {
        this.startView = startView;
        startModel = new StartModel(this);
    }

    @Override
    public void chooseOption(String option) {
        if(!Validation.validateOption(option)){
            startView.invalidOption();
        } else{
            switch (option){
                case "1" -> startView.gotoLogin();
                case "2" -> startView.gotoSignup();
                case "9" -> System.exit(0);
                default -> startView.invalidOption();
            }
        }
    }
}