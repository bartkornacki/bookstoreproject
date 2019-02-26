package utils;

import model.Author;
import model.Book;
import model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DataFromExternalFile {
    private static List<Book> listOfBooks = new ArrayList<>();
    private static List<Author> listOfAuthors = new ArrayList<>();
    private static List<Category> listOfCategories = new ArrayList<>();
    private static BufferedReader reader;

    public static void readDataFromExternalFiles(String fileCategories, String fileAuthors, String fileBooks) {
        readFile(DataType.CATEGORY, fileCategories);
        readFile(DataType.AUTHOR, fileAuthors);
        readFile(DataType.BOOK, fileBooks);
        DataPresenting.showData(listOfBooks, listOfAuthors, listOfCategories);
    }

    private BufferedReader openAnExternalFile(String file) {
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(is);
            return new BufferedReader(isr);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private static String[] splitLine() {
        String line = null;
        try {
            line = reader.readLine();
            return line.split(";");
        } catch (IOException e) {
            return null;
        }
    }

    public static void readFile(DataType dataType, String file) {
        reader = new DataFromExternalFile().openAnExternalFile(file);

        try {
            if (reader != null) {
                while (reader.ready()) {
                    switch (dataType) {
                        case CATEGORY:
                            readCategoryFile();
                            break;
                        case AUTHOR:
                            readAuthorFile();
                            break;
                        case BOOK:
                            readBookFile();
                    }
                }
                reader.close();
            }
            else{
                System.out.println("At least one file wasn't imported. Please ensure that all files exist!");
                listOfCategories = null;
                System.out.println("Category file wasn't read");
                listOfAuthors = null;
                System.out.println("Author file wasn't read");
                listOfBooks = null;
                System.out.println("Book file wasn't read");
                System.exit(1);
            }
        } catch (IOException e) {

        }
    }

    public static void readCategoryFile() {
        String[] stringArray = splitLine();
        listOfCategories.add(new Category(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
    }

    public static void readAuthorFile() {
        String[] stringArray = splitLine();
        listOfAuthors.add(new Author(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
    }

    public static void readBookFile() {
        String[] stringArray = splitLine();
        Category category = getCategory(stringArray[stringArray.length - 1]);
        List<Author> authorsInTheBook = getAuthors(stringArray[5]);

        Book book = new Book(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2]),
                Integer.valueOf(stringArray[3]), stringArray[4], authorsInTheBook, category);
        listOfBooks.add(book);
    }

    private static Category getCategory(String s) {
        try {
            int categoryId = Integer.parseInt(s);
            return listOfCategories.stream()
                    .filter(x -> x.getId() == categoryId)
                    .findFirst().get();
        }
        catch (NoSuchElementException e){
            System.out.println("Category wasn't assigned to the book");
            return null;
        }
    }

    private static List<Author> getAuthors(String s) {
        String[] authorID = s.split(",");
        List<Author> authorsInTheBook = new ArrayList<>();
        for (int i = 0; i < authorID.length; i++) {
            for (Author listOfAuthor : listOfAuthors) {
                if (listOfAuthor.getId() == Integer.parseInt(authorID[i])) {
                    authorsInTheBook.add(listOfAuthor);
                }
            }
        }
        return authorsInTheBook;
    }
}
