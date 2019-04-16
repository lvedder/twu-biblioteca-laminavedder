package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class UserTest {


    @Test
    public void validUserTest() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("111-2233", "melbourne"));
        UserLib library = new UserLib(users);
        assertThat(library.validUserName("111-2233"), is(true));
    }

    @Test
    public void invalidUserTest() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("111-2244", "trier"));
        UserLib library = new UserLib(users);
        assertThat(library.validUserName("xyz"), is(false));
    }

    @Test
    public void validPasswordTest() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-4567", "cologne"));
        UserLib library = new UserLib(users);
        assertThat(library.validPassword("123-4567", "cologne"), is(true));
    }

    @Test
    public void invalidPasswordTest() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-4567", "cologne"));
        users.add(new User("111-2233", "melbourne"));
        users.add(new User( "111-2244", "trier"));
        UserLib library = new UserLib(users);
        assertThat(library.validPassword("123-4567", "1234567"), is(false));
    }
}
