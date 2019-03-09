package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.DataFromExternalFile.readDataFromExternalFiles;

public class MenuMaintenance {

    public void menuNavigation(String fileCategories, String fileAuthors, String fileBooks) {
        MenuMaintenance menuMaintenance = new MenuMaintenance();
        int action;
        do {
            showMenu();
            action = menuMaintenance.getNumberFromUser();
            menuMaintenance.proceedWithChosenAction(action, fileCategories, fileAuthors, fileBooks);
        } while (action != 2);
    }

    public void showMenu() {
        System.out.println("*********************************************************");
        System.out.println("*\t\t\t\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\tPick the action from the list:\t\t\t\t\t\t*");
        System.out.println("*\t\t1.  Show the list of books\t\t\t\t\t\t*");
        System.out.println("*\t\t2.  Show the list of authors\t\t\t\t\t*");
        System.out.println("*\t\t3.  Show the list of categories\t\t\t\t\t*");
        System.out.println("*\t\t4.  Exit\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\t\t5.  Create new author\t\t\t\t\t\t\t*");
        System.out.println("*\t\t6.  Create new category\t\t\t\t\t\t\t*");
        System.out.println("*\t\t7.  Save all collections to external files\t\t*");
        System.out.println("*\t\t8.  Sort by year (ascending)\t\t\t\t\t*");
        System.out.println("*\t\t9.  Sort by year (descending)\t\t\t\t\t*");
        System.out.println("*\t\t10. Show books released after 2003\t\t\t\t*");
        System.out.println("*\t\t11. Edit particular category name\t\t\t\t*");
        System.out.println("*\t\t12. Show all books from 'Wzorce projektowe'\t\t*");
        System.out.println("*\t\t13. Show all books written by particular author\t*");
        System.out.println("*\t\t14. Add tests to methods which write csv files\t*");
        System.out.println("*\t\t\t\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*********************************************************\n");
    }

    private int getNumberFromUser() {
        Scanner scanner = null;
        int temp = 0;
        try{
            scanner = new Scanner(System.in);
            temp = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Number bitch!");
        }
        return temp;
    }

    private void proceedWithChosenAction(int inputAction, String fileCategories, String fileAuthors, String fileBooks) {
        switch (inputAction) {
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
}
