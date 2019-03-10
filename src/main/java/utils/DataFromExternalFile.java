package utils;

import dataStorage.DataStorage;
import model.Author;
import model.Book;
import model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class DataFromExternalFile { //ToDO do pakietu (files?)
    private static List<Book> listOfBooksFromFile = new ArrayList<>();
    private static List<Author> listOfAuthorsFromFile = new ArrayList<>();
    private static List<Category> listOfCategoriesFromFile = new ArrayList<>();
    private static BufferedReader reader;

    public static void readDataFromExternalFiles(String fileCategories, String fileAuthors, String fileBooks) {
        listOfCategoriesFromFile = readCategoryFile(fileCategories);
        listOfAuthorsFromFile = readAuthorFile(fileAuthors);
        listOfBooksFromFile = readBookFile(fileBooks);

        DataStorage dataStorage = new DataStorage();
        dataStorage.setListOfCategories(listOfCategoriesFromFile);
        dataStorage.setListOfAuthors(listOfAuthorsFromFile);
        dataStorage.setListOfBooks(listOfBooksFromFile);
    }

    public static List<Category> readCategoryFile(String file) {
        try {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while (reader.ready()) {
                String[] stringArray = reader.readLine().split(";");
                listOfCategoriesFromFile.add(new Category(
                        Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
            }
        } catch (IOException e) {
            System.out.println("At least one out of three files does not exist. Please ensure all files are uploaded."); //TODO relikt
            System.exit(1);
        }
        return listOfCategoriesFromFile;
    }

    public static List<Author> readAuthorFile(String file) {
        try {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while (reader.ready()) {
                String[] stringArray = reader.readLine().split(";");
                listOfAuthorsFromFile.add(new Author(
                        Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
            }
        } catch (IOException e) {
            System.out.println("Author file doesn't exist. Please ensure all files are uploaded.");
            System.exit(1);
        }
        return listOfAuthorsFromFile;
    }

    public static List<Book> readBookFile(String file) {
        try {
            InputStream is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            while (reader.ready()) {
                String[] stringArray = reader.readLine().split(";"); //TODO zawartosc while do metody
                Category category = getCategory(stringArray[stringArray.length - 1]);

                List<Author> authorsInTheBook = getAuthors(stringArray[5]);

                Book book = new Book(
                        Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2]),
                        Integer.valueOf(stringArray[3]), stringArray[4], authorsInTheBook, category);
                listOfBooksFromFile.add(book);
            }
        } catch (IOException e) {
            System.out.println("Books weren't found. Please ensure 'books' file exists.");
            System.exit(1);
        }
        return listOfBooksFromFile;
    }

    private static Category getCategory(String s) {
//        try {
            int categoryId = Integer.parseInt(s);
        Optional<Category> optionalCategory = listOfCategoriesFromFile.stream()
                .filter(x -> x.getId() == categoryId)
                .findFirst();
//        } catch (NoSuchElementException e) {
//            System.exit(1);
            if( optionalCategory.isPresent()) {
                return optionalCategory.get();
            } else {
                System.out.println("Category wasn't assigned to the book. Please ensure 'category' file exists.");
                return null;
            }
//        }
    }

    private static List<Author> getAuthors(String s) {
        String[] authorID = s.split(",");
        List<Author> authorsInTheBook = new ArrayList<>();
        try {
            for (int i = 0; i < authorID.length; i++) {
                int finalI = i; //TODO dlaczego tak?
                authorsInTheBook.add(listOfAuthorsFromFile.stream()
                        .filter(x -> x.getId() == Integer.valueOf(authorID[finalI]))
                        .findFirst().get());
            }
        } catch (NoSuchElementException e) { //TODO optioal
            System.out.println("Authors weren't assigned to the book. Please ensure 'authors' file exists.");
//            System.exit(1);
            return null;
        }
//        for (int i = 0; i < authorID.length; i++) {
//            for (Author listOfAuthor : listOfAuthorsFromFile) {
//                if (listOfAuthor.getId() == Integer.parseInt(authorID[i])) {
//                    authorsInTheBook.add(listOfAuthor);
//                }
//            }
//        }
        return authorsInTheBook;
    }
}
