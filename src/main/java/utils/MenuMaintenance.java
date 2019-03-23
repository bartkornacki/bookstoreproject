package utils;

import datastorage.DataStorage;
import externalfilesmanagement.DataToExternalFiles;
import externalfilesmanagement.FileNamesMaintenance;
import functions.BookFunctions;
import model.Author;
import model.Book;
import model.Category;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static externalfilesmanagement.DataFromExternalFile.readDataFromExternalFiles;

public class MenuMaintenance {

    private static int exitFromMenu = 4;
    private boolean changeTracker = false;

    public void menuNavigation(String fileCategories, String fileAuthors, String fileBooks) {
        int action;
        readDataFromExternalFiles(fileCategories, fileAuthors, fileBooks);
        do {
            showMenu();
            action = getNumberFromUser();
            proceedWithChosenAction(action);
        } while (action != exitFromMenu);
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
        System.out.println("*\t\t14. Save books to external file\t\t\t\t\t\t\t*");
        System.out.println("*\t\t15. Delete item\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\t\t16. Save the data to external files\t\t\t\t\t\t*");
        System.out.println("*\t\t17. Modify author's name\t\t\t\t\t\t\t\t*");
        System.out.println("*\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*****************************************************************\n");
    }

    private int getNumberFromUser() {
        Scanner scanner = null;
        int numberOfChosenAction = 0;
        try {
            scanner = new Scanner(System.in);
            numberOfChosenAction = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Number bitch!");
        }
        return numberOfChosenAction;
    }

    private void proceedWithChosenAction(int inputAction) {
        DataStorage dataStorage = new DataStorage();
        List<Author> listOfAuthors = dataStorage.getListOfAuthors();
        List<Category> listOfCategories = dataStorage.getListOfCategories();
        List<Book> listOfBooks = dataStorage.getListOfBooks();
        DataPresenting dataPresenting = new DataPresenting();
        ExtendTheList extendTheList = new ExtendTheList();
        DataToExternalFiles dataToExternalFiles = new DataToExternalFiles();
        BookFunctions bookFunctions = new BookFunctions();
        FileNamesMaintenance fileNamesMaintenance = new FileNamesMaintenance();

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
                goodbye(changeTracker);
                break;
            case 5:
                extendTheList.addAuthor();
                changeTracker = true;
                break;
            case 6:
                extendTheList.addCategory();
                changeTracker = true;
                break;
            case 7:
                dataToExternalFiles.writeAuthorsToFile(dataStorage.getListOfAuthors(), fileNamesMaintenance.getFileAuthors());
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
                extendTheList.changeCategoryName(listOfCategories);
                changeTracker = true;
                break;
            case 12:
                dataPresenting.showBooks(bookFunctions.getBooksFromWzorce(listOfBooks));
                break;
            case 13:
                dataPresenting.showBooks(bookFunctions.getBooksByAuthor(listOfAuthors, listOfBooks));
                break;
            case 14:
                dataToExternalFiles.writeBooksToFile(dataStorage.getListOfBooks(), fileNamesMaintenance.getFileBooks());
                break;
            case 15:
                changeTracker = true;
                break;
            case 16:
                dataToExternalFiles.writeCategoriesToFile(dataStorage.getListOfCategories(), fileNamesMaintenance.getFileCategories());
                dataToExternalFiles.writeAuthorsToFile(dataStorage.getListOfAuthors(), fileNamesMaintenance.getFileAuthors());
                dataToExternalFiles.writeBooksToFile(dataStorage.getListOfBooks(), fileNamesMaintenance.getFileBooks());
                break;
            case 17:
                changeTracker = true;
                break;
            default:
                System.out.println("This option is unavailable");
                break;
        }
    }

    private void goodbye(boolean changeTracker) {
        if (!changeTracker) {
            System.out.println("Goodbye.");
        } else {
            checkingWhetherChangesShouldBeSaved();
        }
    }

    private void checkingWhetherChangesShouldBeSaved() {
        System.out.println("Some changes were made. Do you want to save all modified lists to external files? (Y/N)");
        Scanner scanner = new Scanner(System.in);
        String action = "";

        while (!(action.equalsIgnoreCase("n") || action.equalsIgnoreCase("y"))) {
            action = scanner.next();
            if (action.equalsIgnoreCase("n")) {
                System.out.println("Goodbye.");
            } else if (action.equalsIgnoreCase("y")) {
                savingChangesToExternalFilesWhileExit();
            } else {
                System.out.println("Please insert 'N' or 'Y'");
            }
        }
    }

    private void savingChangesToExternalFilesWhileExit() {
        DataToExternalFiles dataToExternalFiles = new DataToExternalFiles();
        DataStorage dataStorage = new DataStorage();
        FileNamesMaintenance fileNamesMaintenance = new FileNamesMaintenance();

        dataToExternalFiles.writeCategoriesToFile(dataStorage.getListOfCategories(), fileNamesMaintenance.getFileCategories());
        dataToExternalFiles.writeAuthorsToFile(dataStorage.getListOfAuthors(), fileNamesMaintenance.getFileAuthors());
        dataToExternalFiles.writeBooksToFile(dataStorage.getListOfBooks(), fileNamesMaintenance.getFileBooks());

        System.out.println("Goodbye.");
    }
}
