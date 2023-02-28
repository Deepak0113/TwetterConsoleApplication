package com.twitterconsole.repository;

import com.twitterconsole.StatusCalls.FollowUserStatusCall;
import com.twitterconsole.StatusCalls.UserStatusCall;
import com.twitterconsole.dto.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Repository {
    private static Repository repository;
    private final String user = "root";
    private final String url = "jdbc:mysql://localhost:3306/twitter";
    private final String password = "Deepak@123";
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public static Repository getInstance(){
        if(repository == null){
            repository = new Repository();
            repository.initSetup();
        }
        return repository;
    }

    private void initSetup(){
        try {
            connection = DriverManager.getConnection(url, user, password);;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /*------ SIGNUP ------*/
    public UserStatusCall signup(String username, String name, String email, String password, String dob){
        try {
            if(isUserAvailable(username))
                return new UserStatusCall("USER EXIST");

            if(isEmailAvailable(email))
                return new UserStatusCall("EMAIL EXIST");

            if(!resultSet.next()){
                // username, passwordHash, name, email, dob, joinedDate
                password = hashPassword(password);
                preparedStatement = connection.prepareStatement("insert into users (username, passwordHash, name, email, dob) values (?, ?, ?, ?, ?)");
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, name);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, dob);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(resultSet != null) resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return new UserStatusCall("SUCCESS");
    }

    private boolean isUserAvailable(String userId){
        try{
            preparedStatement = connection.prepareStatement("select username from users where username = ?");
            preparedStatement.setString(1, userId);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next())
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean isEmailAvailable(String email){
        try{
            preparedStatement = connection.prepareStatement("select username from users where email = ?");
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            if(!resultSet.next())
                return false;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }


    /*------ LOGIN ------*/
    public UserStatusCall login(String username, String password){
        try{
            password = hashPassword(password);
            preparedStatement = connection.prepareStatement("select * from users where username = ?");
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                String passwordValidate = resultSet.getString(2);

                return password.equals(passwordValidate) ?
                        new UserStatusCall("SUCCESS", resultSet) :
                        new UserStatusCall("INCORRECT PASSWORD");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new UserStatusCall("NOT EXISTS");
    }


    /*------ POST TWEET ------*/
    public boolean postTweet(User user, String tweet){
        boolean isPosted = false;

        try{
            preparedStatement = connection.prepareStatement("insert into posts (username, postText) values (?, ?);");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, tweet);
            preparedStatement.execute();
            isPosted = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isPosted;
    }


    /*------ VIEW MY TWEETS ------*/
    public ResultSet viewMyTweets(User user) {
        try {
            preparedStatement = connection.prepareStatement("select * from posts where username = ? order by postTime desc;");
            preparedStatement.setString(1, user.getUsername());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }


    /*------ DELETE TWEET ------*/
    public boolean deleteTweet(User user, String tweetId) {
        boolean isDeleted = false;
        try{
            preparedStatement = connection.prepareStatement("delete from posts where postID = ? and username = ?");
            preparedStatement.setString(1, tweetId);
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.execute();
            isDeleted = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isDeleted;
    }


    /*------ FOLLOW USER ------*/
    public FollowUserStatusCall followUser(User user, String userId){
        try{
            if(!isUserAvailable(userId))
                return new FollowUserStatusCall("NOT EXIST");
            if(isFollowingUser(user.getUsername(), userId))
                return new FollowUserStatusCall("FOLLOWING");

            preparedStatement = connection.prepareStatement("insert into relationship values (?,?)");
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, userId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new FollowUserStatusCall("SUCCESS");
    }

    private boolean isFollowingUser(String username, String userId){
        try{
            preparedStatement = connection.prepareStatement("select * from relationship where follower = ? and following = ?");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, userId);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    /*------ VIEW FOLLOWING ------*/
    public ResultSet viewFollowing(User user){
        try{
            preparedStatement = connection.prepareStatement("select following from relationship where follower = ?");
            preparedStatement.setString(1, user.getUsername());
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    /*------ VIEW FOLLOWERS ------*/
    public ResultSet viewFollower(User user){
        try{
            preparedStatement = connection.prepareStatement("select follower from relationship where following = ?");
            preparedStatement.setString(1, user.getUsername());
            resultSet = preparedStatement.executeQuery();
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }


    /*------ VIEW TWEETS ------*/
    public ResultSet viewTweets(User user){
        try{
            String query = "select * from posts where username in (select following from relationship where follower=?) or username=? order by postTime desc";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getUsername());
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultSet;
    }


    /*------ HASHING ------*/
    private String hashPassword(String password){
        StringBuilder hashedPass = null;

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");
            messageDigest.update(password.getBytes());
            hashedPass = new StringBuilder();
            for (byte b: messageDigest.digest())
                hashedPass.append(String.format("%02X", b));
        } catch (NoSuchAlgorithmException ignored) {
        }

        assert hashedPass != null;
        return hashedPass.toString();
    }
}
