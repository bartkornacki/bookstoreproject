package utils;

import model.Author;
import model.Book;
import model.Category;

import java.util.ArrayList;
import java.util.List;

public class DataStorage {
    private static List<Book> listOfBooksFromFile = new ArrayList<>();
    private static List<Author> listOfAuthorsFromFile = new ArrayList<>();
    private static List<Category> listOfCategoriesFromFile = new ArrayList<>();

//    DataFromExternalFile dataFromExternalFile = new DataFromExternalFile();

    public static List<Book> getListOfBooksFromFile() {
        return listOfBooksFromFile;
    }

    public static void setListOfBooksFromFile(List<Book> listOfBooksFromFile) {
        DataStorage.listOfBooksFromFile = listOfBooksFromFile;
    }

    public static List<Author> getListOfAuthorsFromFile() {
        return listOfAuthorsFromFile;
    }

    public static void setListOfAuthorsFromFile(List<Author> listOfAuthorsFromFile) {
        DataStorage.listOfAuthorsFromFile = listOfAuthorsFromFile;
    }

    public static List<Category> getListOfCategoriesFromFile() {
        return listOfCategoriesFromFile;
    }

    public static void setListOfCategoriesFromFile(List<Category> listOfCategoriesFromFile) {
        DataStorage.listOfCategoriesFromFile = listOfCategoriesFromFile;
    }
}
