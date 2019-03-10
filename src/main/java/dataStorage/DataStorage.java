package dataStorage;

import model.Author;
import model.Book;
import model.Category;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static List<Book> listOfBooks = new ArrayList<>();
    private static List<Author> listOfAuthors = new ArrayList<>();
    private static List<Category> listOfCategories = new ArrayList<>();

    public static List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public static void setListOfBooks(List<Book> listOfBooks) {
        DataStorage.listOfBooks = listOfBooks;
    }

    public static List<Author> getListOfAuthors() {
        return listOfAuthors;
    }

    public static void setListOfAuthors(List<Author> listOfAuthors) {
        DataStorage.listOfAuthors = listOfAuthors;
    }

    public static List<Category> getListOfCategories() {
        return listOfCategories;
    }

    public static void setListOfCategories(List<Category> listOfCategories) {
        DataStorage.listOfCategories = listOfCategories;
    }
}
