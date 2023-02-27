package com.twitterconsole.login;

import com.twitterconsole.StatusCalls.UserStatusCall;
import com.twitterconsole.dto.User;
import com.twitterconsole.repository.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginModel implements LoginModelCallback {
    LoginModelControllerCallback loginController;

    LoginModel(LoginModelControllerCallback loginController) {
        this.loginController = loginController;
    }


    @Override
    public void login(String username, String password) {
        UserStatusCall userStatusCall = Repository.getInstance().login(username, password);
        switch (userStatusCall.getStatus()){
            case "SUCCESS" -> {
                ResultSet resultSet = userStatusCall.getResultSet();
                try{
                    loginController.loginSuccess(new User(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getDate(5),
                            resultSet.getTimestamp(6)
                    ));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            case "NOT EXISTS" -> loginController.invalidMessage("Login failed user doesn't exit");
            case "INCORRECT PASSWORD" -> loginController.invalidMessage("Login failed incorrect password");
        }
    }
}