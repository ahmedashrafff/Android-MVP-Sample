package com.example.shade.mvpsample.data.model;

public class User implements UserInterface {

    String userName;
    String userPassword;


    public User() {
        this.userName = "Ahmed";
        this.userPassword = "123";
    }

    @Override
    public String getuserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

}
