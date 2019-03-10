package bookstore;

import utils.MenuMaintenance;

public class Main {
    public static void main(String[] args) {
        MenuMaintenance menuMaintenance = new MenuMaintenance();

        String fileCategories = "categories.csv";
        String fileAuthors = "authors.csv";
        String fileBooks = "books.csv";

        menuMaintenance.menuNavigation(fileCategories, fileAuthors, fileBooks);
    }
}
