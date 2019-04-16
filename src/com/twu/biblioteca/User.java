package com.twu.biblioteca;

public class User {
    private String libraryNum;
    private String password;

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

