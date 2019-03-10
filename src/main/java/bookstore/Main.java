package bookstore;

import utils.MenuMaintenance;

public class Main {
    public static void main(String[] args) {
        MenuMaintenance menuMaintenance = new MenuMaintenance();

        String fileCategories = "categories.csv";
        String fileAuthors = "authors.csv";
        String fileBooks = "books.csv";

        menuMaintenance.menuNavigation(fileCategories, fileAuthors, fileBooks);
        //TODO co jesli ktos w wiek autora wpisze "dasdsa"
    }
}
