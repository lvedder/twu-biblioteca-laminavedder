package com.twu.biblioteca;

public class User {
    private String userName;
    private String libraryNum;
    private String password;

    public User(String userName, String libraryNum, String password) {
        this.userName = userName;
        this.libraryNum = libraryNum;
        this.password = password;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}

