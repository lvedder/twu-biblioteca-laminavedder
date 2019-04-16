package com.twu.biblioteca;

import java.util.ArrayList;

public class UserLib {

    private ArrayList<User> users;

    public UserLib(ArrayList users) {
        this.users = users;
    }

    public Boolean validUserName(String num) {
        for (User user : users) {
            if (user.getLibraryNum().equals(num)) {
                return true;
            }
        }
        return false;
    }

    public Boolean validPassword(String LibraryNum, String password) {
        for (User user : users) {
            if (user.getLibraryNum().equals(LibraryNum)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
