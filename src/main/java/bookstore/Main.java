package bookstore;

import utils.MenuMaintenance;

public class Main {
    public static void main(String[] args) {
        MenuMaintenance menuMaintenance = new MenuMaintenance();

        String fileCategories = "src/main/resources/categories.csv";
        String fileAuthors = "src/main/resources/authors.csv";
        String fileBooks = "src/main/resources/books.csv";

        menuMaintenance.menuNavigation(fileCategories, fileAuthors, fileBooks);
    }
}
