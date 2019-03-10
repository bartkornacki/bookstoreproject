package utils;

import functions.BookFunctions;
import model.Author;
import model.Book;
import model.Category;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static utils.DataFromExternalFile.readDataFromExternalFiles;

public class MenuMaintenance {

    private static List<Book> listOfBooks = new ArrayList<>();
    private static List<Author> listOfAuthors = new ArrayList<>();
    private static List<Category> listOfCategories = new ArrayList<>();

    public void menuNavigation(String fileCategories, String fileAuthors, String fileBooks) {
        MenuMaintenance menuMaintenance = new MenuMaintenance(); //TODO mozna bez tego
        int action;
                readDataFromExternalFiles(fileCategories, fileAuthors, fileBooks);
        do {
            showMenu();
            action = menuMaintenance.getNumberFromUser();
            menuMaintenance.proceedWithChosenAction(action, fileCategories, fileAuthors, fileBooks);
        } while (action != 4);
    }

    public void showMenu() {
        System.out.println("*****************************************************************");
        System.out.println("*\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\tPick the action from the list:\t\t\t\t\t\t\t\t*");
        System.out.println("*\t\t1.  Show the list of books\t\t\t\t\t\t\t\t*");
        System.out.println("*\t\t2.  Show the list of authors\t\t\t\t\t\t\t*");
        System.out.println("*\t\t3.  Show the list of categories\t\t\t\t\t\t\t*");
        System.out.println("*\t\t4.  Exit\t\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\t\t5.  Create new author\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\t\t6.  Create new category\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\t\t7.  Save authors to external file\t\t\t\t\t\t*");
        System.out.println("*\t\t8.  Sort by year (ascending)\t\t\t\t\t\t\t*");
        System.out.println("*\t\t9.  Sort by year (descending)\t\t\t\t\t\t\t*");
        System.out.println("*\t\t10. Show books released after 2003\t\t\t\t\t\t*");
        System.out.println("*\t\t11. Edit particular category name\t\t\t\t\t\t*");
        System.out.println("*\t\t12. Show all books from 'Wzorce projektowe'\t\t\t\t*");
        System.out.println("*\t\t13. Show all books written by particular author\t\t\t*");
        System.out.println("*\t\t14. Add tests to methods which write csv files\t\t\t*");
        System.out.println("*\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*****************************************************************\n");
    }

    private int getNumberFromUser() {
        Scanner scanner = null;
        int temp = 0; //TODO nazwa
        try{
            scanner = new Scanner(System.in);
            temp = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Number bitch!");
        }
        return temp;
    }

    private void proceedWithChosenAction(int inputAction, String fileCategories, String fileAuthors, String fileBooks) { //TODO nieuzywane parametry
        DataStorage dataStorage = new DataStorage();
        listOfAuthors = dataStorage.getListOfAuthors();
        listOfCategories = dataStorage.getListOfCategories();
        listOfBooks = dataStorage.getListOfBooks();
        DataPresenting dataPresenting = new DataPresenting();
        ExtendTheList extendTheList = new ExtendTheList();
        DataToExternalFiles dataToExternalFiles = new DataToExternalFiles();
        BookFunctions bookFunctions = new BookFunctions();

        switch (inputAction) {
            case 1:
                dataPresenting.showBooks(listOfBooks);
                break;
            case 2:
                dataPresenting.showAuthors(listOfAuthors);
                break;
            case 3:
                dataPresenting.showCategories(listOfCategories);
                break;
            case 4:
                System.out.println("Goodbye.");
                break;
            case 5:
                extendTheList.addAuthor();
                break;
            case 6:
                extendTheList.addCategory();
                break;
            case 7:
                dataToExternalFiles.writeAuthorsToFile(dataStorage.getListOfAuthors(),"authors.csv");
                break;
            case 8:
                dataPresenting.showBooks(bookFunctions.sortBooksFromOldestStream(listOfBooks));
                break;
            case 9:
                dataPresenting.showBooks(bookFunctions.sortBooksFromNewestStream(listOfBooks));
                break;
            case 10:
                dataPresenting.showBooks(bookFunctions.getBooksReleasedAfter2003stream(listOfBooks));
                break;
            case 11:
                dataPresenting.showCategories(extendTheList.changeCategoryName(listOfCategories));
                break;
            case 12:
                dataPresenting.showBooks(bookFunctions.getBooksFromWzorce(listOfBooks));
                break;
            case 13:
                dataPresenting.showBooks(bookFunctions.getBooksByAuthor(listOfAuthors, listOfBooks));
                break;
            case 14:

                break;
            default:
                System.out.println("This option is unavailable");
                break;
        }
    }
}
