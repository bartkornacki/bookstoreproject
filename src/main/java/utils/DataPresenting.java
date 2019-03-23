package utils;

import model.Author;
import model.Book;
import model.Category;

import java.util.List;
import java.util.Scanner;

public class DataPresenting {
    public static int displayTypeID = 1;

    public void showCategories(List<Category> listOfCategories) {
        for (Category category : listOfCategories) {
            System.out.println(category.toString());
        }
    }

    public void showAuthors(List<Author> listOfAuthors) {
        for (Author author : listOfAuthors) {
            System.out.println(author.toString());
        }
    }

    public void showBooks(List<Book> listOfBooks) {
        System.out.println(displayTypeID);
        for (Book book : listOfBooks) {
            switch (displayTypeID) {
                case 1:
                    System.out.println(book.toString());
                    break;
                case 2:
                    System.out.println(book.getTitle() + " | " +
                            book.getIsbnNumber() + " | " + book.getYear());
                    break;
                case 3:
                    System.out.println(book.getTitle() + " | " +
                            book.getYear() + " | " + book.getIsbnNumber());
                    break;
            }
        }
    }

    public int chooseBookDisplayMethod() {
        System.out.println("Please choose the display method:" +
                "\n1. Standard" +
                "\n2. Title | ISBN | Year" +
                "\n3. Title | Year |ISBN");
        Scanner scanner = new Scanner(System.in);
        String action = "";

        while (!(action.equalsIgnoreCase("1") || action.equalsIgnoreCase("2")
                || action.equalsIgnoreCase("3"))) {
            action = scanner.next();
            if (action.equals("1") || action.equals("2") || action.equals("3")) {
                displayTypeID = Integer.parseInt(action);
            } else {
                System.out.println("Please choose 1, 2 or 3");
            }
        }
        System.out.println(displayTypeID);
        return displayTypeID;
    }
}
