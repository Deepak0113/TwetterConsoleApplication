package com.twitterconsole.StatusCalls;

import java.sql.ResultSet;

public class UserStatusCall extends Status{
    private ResultSet resultSet;

    public UserStatusCall(String status){
        super(status);
    }

    public UserStatusCall(String status, ResultSet resultSet) {
        super(status);
        this.resultSet = resultSet;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }
}
