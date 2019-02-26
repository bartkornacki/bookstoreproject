package bookstore;

import utils.*;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String fileCategories = "categories.csv";
        String fileAuthors = "authors.csv";
        String fileBooks = "books.csv";

        MenuMaintenance.menuNavigation(fileCategories, fileAuthors, fileBooks);
    }
}
