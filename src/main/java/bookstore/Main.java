package bookstore;

import utils.*;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileCategories = "categories.csv";
        String fileAuthors = "authors.csv";
        String fileBooks = "books2.csv";

        MenuMaintenance.menuNavigation(fileCategories, fileAuthors, fileBooks);
    }
}
