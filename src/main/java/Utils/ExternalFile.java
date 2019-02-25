package Utils;

import model.Author;
import model.Book;
import model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExternalFile {
    private static List<Book> listOfBooks = new ArrayList<>();
    private static List<Author> listOfAuthors = new ArrayList<>();
    private static List<Category> listOfCategories = new ArrayList<>();
    private static List<String> tempList = new ArrayList<>();
    private static BufferedReader reader;

    public static void readDataFromExternalFiles(String fileCategories, String fileAuthors, String fileBooks) throws IOException {
        readFile(DataType.CATEGORY, fileCategories);
        readFile(DataType.AUTHOR, fileAuthors);
//        readFile(DataType.BOOK, fileBooks);
        readBookFile(fileBooks);

        DataPresenting.showData(listOfBooks, listOfAuthors, listOfCategories);
    }

    private BufferedReader openAnExternalFile(String file) throws FileNotFoundException {
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is);
        return new BufferedReader(isr);
    }

    private static String[] splitLine() throws IOException {
        String line = reader.readLine();
        return line.split(";");
    }


    public static void readBookFile(String file) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
        while (reader.ready()) {
            String[] stringArray = splitLine();
            fulfillListOfBooks(stringArray);
        }
        reader.close();
    }

    private static void fulfillListOfBooks(String[] stringArray) {
        int categoryId = Integer.parseInt(stringArray[stringArray.length - 1]);
        String[] authorID = stringArray[5].split(",");
        List<Author> authorsInTheBook = new ArrayList<>();

        Category category = getCategory(listOfCategories, categoryId);
        getListOfAuthorsInTheBook(listOfAuthors, authorID, authorsInTheBook);

        Book book = new Book(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2]),
                Integer.valueOf(stringArray[3]), stringArray[4], authorsInTheBook, category);
        listOfBooks.add(book);
    }

    private static void getListOfAuthorsInTheBook(List<Author> listOfAuthors, String[] authorID, List<Author> authorsInTheBook) {
        for (int i = 0; i < authorID.length; i++) {
            for (Author listOfAuthor : listOfAuthors) {
                if (listOfAuthor.getId() == Integer.parseInt(authorID[i])) {
                    authorsInTheBook.add(listOfAuthor);
                }
            }
        }
    }

    private static Category getCategory(List<Category> listOfCategories, int categoryId) {
        return listOfCategories.stream()
                .filter(x -> x.getId() == categoryId)
                .findFirst().get();
    }

    public static void readFile(DataType dataType, String file) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
        while (reader.ready()) {
            String[] stringArray = splitLine();
            switch (dataType){
                case CATEGORY:
                    listOfCategories.add(new Category(
                            Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
                case AUTHOR:
                    listOfAuthors.add(new Author(
                            Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
//                case BOOK:
//                    fulfillListOfBooks(stringArray);
            }
        }
        reader.close();
    }

    public static void readCategoryFile(String file) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
        while (reader.ready()) {
            String[] stringArray = splitLine();
            listOfCategories.add(new Category(
                    Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
        }
        reader.close();
    }

    public static void readAuthorFile(String file) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
        while (reader.ready()) {
            String[] stringArray = splitLine();
            listOfAuthors.add(new Author(
                    Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
        }
        reader.close();
    }
}
