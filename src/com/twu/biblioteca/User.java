package com.twu.biblioteca;

public class User {
    private String libraryNum;
    private String password;
    private String email;
    private String phone;
    private String name;

    //TODO: 2.4 Add user information (name, email and phone number) + getter for various info

    public User(String libraryNum, String password, String email, String phone, String name) {
        this.libraryNum = libraryNum;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
    }


    public String getLibraryNum() {
        return libraryNum;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "E-Mail: " + email + "\n" + "mobile: " + phone + "\n" + "name: " + name;
    }
}

