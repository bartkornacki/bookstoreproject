package utils;

import java.io.IOException;
import java.util.Scanner;

import static utils.DataFromExternalFile.readDataFromExternalFiles;

public class MenuMaintenance {

    public static void menuNavigation(String fileCategories, String fileAuthors, String fileBooks) throws IOException {
        String action;
        do {
            showMenu();
            action = insertTheNumberOfAnAction();
            proceedWithChosenAction(action, fileCategories, fileAuthors, fileBooks);
        } while (action != "2");
    }

    public static void showMenu() {
        System.out.println("*********************************************************");
        System.out.println("*\t\t\t\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\tPick the action from the list:\t\t\t\t\t\t*");
        System.out.println("*\t\t1. Show books stored in the external file\t\t*");
        System.out.println("*\t\t2. Exit\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*\t\t\t\t\t\t\t\t\t\t\t\t\t\t*");
        System.out.println("*********************************************************\n");
    }

    private static String insertTheNumberOfAnAction() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    private static void proceedWithChosenAction(String readAction, String fileCategories, String fileAuthors, String fileBooks) throws IOException {
        switch (readAction) {
            case "1":
                readDataFromExternalFiles(fileCategories, fileAuthors, fileBooks);
                break;
            case "2":
                System.out.println("Goodbye.");
                break;
            default:
                System.out.println("This option is unavailable");
                break;
        }
    }
}
