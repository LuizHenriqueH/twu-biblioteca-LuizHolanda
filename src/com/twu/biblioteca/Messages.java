package com.twu.biblioteca;

public class Messages {

    public final String messageWelcome = "welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    public final String menuOptionMessage = "- Press 1 to see the list of books \n" +
            "- Press 2 to rent a Book \n" +
            "- Press 3 to return a Book \n" +
            "- Press 9 to quit the application";
    public final String inputMessage = "Please select an Option: ";
    public final String bookIDMessage = "Enter the book id: ";
    public final String optionUnavailable = "Please select a valid option!";
    public final String exitMessage = "Thank you for using our application.";
    public final String unexpectedValueMessage = "Unexpected value, please input a number.";
    public final String bookRentalSucessMessage = "Thank you! Enjoy the Book.";
    public final String bookRentalUnavailableMessage = "Sorry! The book is not available.";
    public final String bookReturnSucessMessage = "Thank you for returning the book.";
    public final String invalidBookReturnMessage = "That is not a valid book to return.";

    public void mainMenu(int value){
        if(value == 0) {
            System.out.println(messageWelcome);
        }
    }
}
