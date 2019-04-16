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
        System.out.println(welcomeMessage());
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
        users.add(new User("123-4567", "cologne"));
        users.add(new User( "111-2233", "melbourne"));
        users.add(new User( "111-2244", "trier"));
    }


    public static String welcomeMessage() {
        String msg = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\nPlease provide your username.";
        return msg;
    }

    public static void systemOutput() {
        System.out.println("1\tList of books");
        System.out.println("2\tSelect a book");
        System.out.println("3\tReturn a book");
        System.out.println("4\tList of movies");
        System.out.println("5\tLend a movie");
        System.out.println("6\tExit Biblioteca");
        System.out.println("Please enter your choice:");
    }

    public static void getUserChoice() {
        Scanner input = new Scanner(System.in);
        String user;
        do { user = input.nextLine();
        } while (user.equals(""));
        UserLib userName = new UserLib(users);
        if (userName.validUserName(user)) {
            String password;
            do {
                System.out.println("Please enter your password:");
                password = input.nextLine();
            } while (password.equals(""));
            if (userName.validPassword(user, password)) {
                systemOutput();
                int choice;
                do {
                    System.out.println("What would you like to do next?");
                    choice = input.nextInt();
                    switch (choice) {
                        case LIST_BOOK_OPTION:
                            System.out.println(new Library(books).listOfBooks());
                            break;
                        case 2:
                            System.out.println(new Library(books).listOfBooks());
                            System.out.println("Which book would you like to borrow? Please provide a title.");
                            String bookChoice;
                            do {
                                bookChoice = input.nextLine();
                            } while (bookChoice.equals(""));
                            Library lib = new Library(books);
                            if (lib.hasBook(bookChoice)) {
                                System.out.println("Thank you! Enjoy the book");
                                lib.removeBook(bookChoice);
                            } else {
                                System.out.println("Sorry, that book is not available");
                            }
                            break;
                        case 3:
                            System.out.println("Which book would you like to return? Please provide the title.");
                            String returnBook;
                            do {
                                returnBook = input.nextLine();
                            } while (returnBook.equals(""));
                            Library currLib = new Library(books);
                            if (currLib.isNotInStock(returnBook)) {
                                currLib.addBook(returnBook);
                                System.out.println("Thank you for returning the book.");
                            } else {
                                System.out.println("That is not a valid book to return.");
                            }
                        case 4:
                            movieList();
                            break;
                        case 5:
                            System.out.println("Which movie would you like to lend? Please provide a title.");
                            String movieChoice;
                            do {
                                movieChoice = input.nextLine();
                            } while (movieChoice.equals(""));
                            MovieLibrary movLib = new MovieLibrary(movies);
                            if (movLib.hasMovie(movieChoice)) {
                                movLib.borrowMovie(movieChoice);
                                System.out.println("Thank you for lending a movie with Biblioteca App");
                            } else {
                                System.out.println("Sorry, that movie is not available");
                            }
                        case 6:
                            System.out.println("Goodbye. Thank you for using Biblioteca!");
                            break;
                        default:
                            System.out.println("Please select a valid option!");
                    }
                } while (choice != 6);
            } else {
                System.out.println("Sorry, this is no valid password.");
            }
            System.out.println("Sorry, this is no valid user name");
        }
    }

    public static void movieList() {
        MovieLibrary movieLib = new MovieLibrary(movies);
        String list = movieLib.listOfMovies();
        System.out.println(list);
    }
}