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
        System.out.println("*\t\t1. Show books stored in the external file\t\t*");
        System.out.println("*\t\t2. Exit\t\t\t\t\t\t\t\t\t\t\t*");
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
