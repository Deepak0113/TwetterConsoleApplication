package com.twitterconsole.utility;

public class Validation {
    public static boolean validateOption(String option){
        String regex = "[0-9]";
        return option.matches(regex);
    }

    public static boolean validateName(String username) {
        return username.length() != 0;
    }

    public static boolean validateEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\\\.[a-zA-Z]{2,}$");
    }

    public static boolean validatePassword(String password) {
        return password.length()>6;
    }
}