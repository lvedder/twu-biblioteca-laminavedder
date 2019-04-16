package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class UserTest {


    @Test
    public void validUserTest() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("111-2233", "melbourne", "abentley@thoughtworks.com", "01237858965", "Andrew Bentley"));
        UserLib library = new UserLib(users);
        assertThat(library.validUserName("111-2233"), is(true));
    }

    @Test
    public void invalidUserTest() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("111-2244", "trier", "andreas.freund@thoughtworks.com", "01532158697", "Andreas Freund"));
        UserLib library = new UserLib(users);
        assertThat(library.validUserName("xyz"), is(false));
    }

    @Test
    public void validPasswordTest() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-4567", "cologne", "lamina.vedder@thoughtworks.com", "015144241278","Lamina Vedder"));
        UserLib library = new UserLib(users);
        assertThat(library.validPassword("123-4567", "cologne"), is(true));
    }

    @Test
    public void invalidPasswordTest() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("123-4567", "cologne", "lamina.vedder@thoughtworks.com", "015144241278","Lamina Vedder"));
        users.add(new User("111-2233", "melbourne", "abentley@thoughtworks.com", "01237858965", "Andrew Bentley"));
        users.add(new User( "111-2244", "trier", "andreas.freund@thoughtworks.com", "01532158697", "Andreas Freund"));
        UserLib library = new UserLib(users);
        assertThat(library.validPassword("123-4567", "1234567"), is(false));
    }

    @Test
    public void getUserInformation() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User( "111-2244", "trier", "andreas.freund@thoughtworks.com", "01532158697", "Andreas Freund"));
        UserLib library = new UserLib(users);
        assertThat(library.getUserInformation("111-2244"), containsString("andreas.freund@thoughtworks.com"));
    }
}
