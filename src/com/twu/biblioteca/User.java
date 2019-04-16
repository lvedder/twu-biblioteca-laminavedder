package com.twu.biblioteca;

public class User {
    private String libraryNum;
    private String password;

    //TODO: 2.4 Add user information (name, email and phone number) + getter for various info

    public User(String libraryNum, String password) {
        this.libraryNum = libraryNum;
        this.password = password;
    }


    public String getLibraryNum() {
        return libraryNum;
    }

    public String getPassword() {
        return password;
    }
}

