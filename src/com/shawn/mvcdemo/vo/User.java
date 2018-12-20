package com.shawn.mvcdemo.vo;

public class User{
    private String userID;

    private String name;

    private String password;

    public String getUserID(){
        return this.userID;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
