package Utils;

import model.Author;
import model.Book;
import model.Category;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MenuMaintenance {

    public static void menuNavigation(String fileCategories, String fileAuthors, String fileBooks) throws IOException {
        int action;
        do {
            showMenu();
            action = insertTheNumberOfAnAction();
            chooseAnActionFromTheMenu(action, fileCategories, fileAuthors, fileBooks);
        } while (action != 2);
    }

    public static void showMenu(){
        System.out.println("*********************************************************");
        System.out.println("*\t\t\t\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\tPick the action from the list:\t\t\t\t\t\t*");
        System.out.println("*\t\t1. Show books stored in the external file\t\t*");
        System.out.println("*\t\t2. Exit\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\t\t\t\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*********************************************************\n");
    }

    private static int insertTheNumberOfAnAction() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void chooseAnActionFromTheMenu(int readAction, String fileCategories, String fileAuthors, String fileBooks) throws IOException {
        switch (readAction) {
            case 1:
                readDataFromExternalFiles(fileCategories, fileAuthors, fileBooks);
                break;
            case 2:
                System.out.println("Goodbye.");
                break;
            default:
                System.out.println("This option is unavailable");
                break;
        }
    }

    public static void readDataFromExternalFiles(String fileCategories, String fileAuthors, String fileBooks) throws IOException {
        List<Book> listOfBooks;
        List<Author> listOfAuthors;
        List<Category> listOfCategories;

        listOfCategories = ExternalFile.categoryFileReader(fileCategories);
        listOfAuthors = ExternalFile.authorFileReader(fileAuthors);
        listOfBooks = ExternalFile.bookFileReader(fileBooks, listOfCategories, listOfAuthors);

//        ExternalFile.categoriesReader(listOfCategories);
//        ExternalFile.authorsReader(listOfAuthors);
        ExternalFile.booksReader(listOfBooks);
    }
}
