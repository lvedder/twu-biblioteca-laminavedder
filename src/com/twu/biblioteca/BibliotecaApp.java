package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static final int LIST_BOOK_OPTION = 1;
    static ArrayList<Book> books = new ArrayList<Book>();
    static ArrayList<Movie> movies = new ArrayList<Movie>();
    static ArrayList<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        setUpBooks();
        setUpMovies();
        setUpUsers();
        stringOutput(welcomeMessage());
        getUserChoice();
    }

    private static void setUpBooks() {
        books.add(new Book("The Big Five For Life", "John Strelecky", "2008"));
        books.add(new Book("The Why Are You Here Cafe", "John Strelecky", "2003"));
        books.add(new Book("The Alchemist", "Paulo Coelho", "1988"));
    }

    private static void setUpMovies() {
        movies.add(new Movie("Inception", "Christopher Nolan", "2010", "7"));
        movies.add(new Movie("Interstellar", "Christopher Nolan", "2014", "8"));
    }

    private static void setUpUsers() {
        users.add(new User("123-4567", "cologne","lamina.vedder@thoughtworks.com", "015144241278","Lamina Vedder"));
        users.add(new User( "111-2233", "melbourne", "abentley@thoughtworks.com", "01237858965", "Andrew Bentley"));
        users.add(new User( "111-2244", "trier", "andreas.freund@thoughtworks.com", "01532158697", "Andreas Freund"));
    }


    public static String welcomeMessage() {
        String msg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
        return msg;
    }

    public static void systemOutput() {
        stringOutput("1\tList of books");
        stringOutput("2\tSelect a book");
        stringOutput("3\tReturn a book");
        stringOutput("4\tList of movies");
        stringOutput("5\tLend a movie");
        stringOutput("6\tExit Biblioteca");
        stringOutput("7\tYour user info");
        stringOutput("Please enter your choice:");
    }

    public static Boolean validateUser(Scanner input) {
        stringOutput("Please provide your library number");
        String user;
        do {
            user = input.nextLine();
        } while (user.equals(""));
        UserLib userLibNum = new UserLib(users);
        if (userLibNum.validUserName(user)) {
            String password;
            do {
                stringOutput("Please enter your password:");
                password = input.nextLine();
            } while (password.equals(""));
            if (userLibNum.validPassword(user, password)) return true;
            return false;
        }
        return false;
    }

    public static void getUserChoice() {
        Scanner input = new Scanner(System.in);
        if (validateUser(input)) {
            systemOutput();
            int choice;
            do {
                stringOutput("What would you like to do next?");
                choice = input.nextInt();
                switch (choice) {
                    case LIST_BOOK_OPTION:
                        System.out.println(new Library(books).listOfBooks());
                        break;
                    case 2:
                        borrow(input);
                        break;
                    case 3:
                        returnItem(input);
                        break;
                    case 4:
                        movieList();
                        break;
                    case 5:
                        lendMovie(input);
                        break;
                    case 6:
                        stringOutput("Goodbye. Thank you for using Biblioteca!");
                        break;
                    case 7:
                        infoList(input);
                        break;
                    //TODO: 2.4 Add case 7 in which user can access his/her user information (name, email and phone number)
                    default:
                        stringOutput("Please select a valid option!");
                }
            } while (choice != 6);
        } else {
            stringOutput("Sorry, this is no valid library number and password.");
        }
    }

    private static void stringOutput(String s) {
        System.out.println(s);
    }

    private static void lendMovie(Scanner input) {
        stringOutput("Which movie would you like to lend? Please provide a title.");
        String movieChoice;
        do {
            movieChoice = input.nextLine();
        } while (movieChoice.equals(""));
        MovieLibrary movLib = new MovieLibrary(movies);
        if (movLib.hasMovie(movieChoice)) {
            movLib.borrowMovie(movieChoice);
            stringOutput("Thank you for lending a movie with Biblioteca App");
        } else {
            stringOutput("Sorry, that movie is not available");
        }
    }

    private static void returnItem(Scanner input) {
        stringOutput("Which book would you like to return? Please provide the title.");
        String returnBook;
        do {
            returnBook = input.nextLine();
        } while (returnBook.equals(""));
        Library currLib = new Library(books);
        if (currLib.isNotInStock(returnBook)) {
            currLib.addBook(returnBook);
            stringOutput("Thank you for returning the book.");
        } else {
            stringOutput("That is not a valid book to return.");
        }
    }

    private static void borrow(Scanner input) {
        System.out.println(new Library(books).listOfBooks());
        stringOutput("Which book would you like to borrow? Please provide a title.");
        String bookChoice;
        do {
            bookChoice = input.nextLine();
        } while (bookChoice.equals(""));
        Library lib = new Library(books);
        if (lib.hasBook(bookChoice)) {
            stringOutput("Thank you! Enjoy the book");
            lib.removeBook(bookChoice);
        } else {
            stringOutput("Sorry, that book is not available");
        }
    }

    public static void infoList(Scanner input) {
        stringOutput("Please provide your library number again.");
        String libNum;
        do {
            libNum = input.nextLine();
        } while (libNum.equals(""));
        UserLib userInfo = new UserLib(users);
        String info = userInfo.getUserInformation(libNum);
        stringOutput(info);
    }

    public static void movieList() {
        MovieLibrary movieLib = new MovieLibrary(movies);
        String list = movieLib.listOfMovies();
        stringOutput(list);
    }
}