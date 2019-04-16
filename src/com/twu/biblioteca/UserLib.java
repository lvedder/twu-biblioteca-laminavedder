package com.twu.biblioteca;

import java.util.ArrayList;

public class UserLib {

    private ArrayList<User> users;

    public UserLib(ArrayList users) {
        this.users = users;
    }

    public Boolean validUserName(String name) {
        for (User user : users) {
            if (user.getUserName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Boolean validPassword(String userName, String password) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
