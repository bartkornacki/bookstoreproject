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
    private static BufferedReader reader;

    public static void readDataFromExternalFiles(String fileCategories, String fileAuthors, String fileBooks) throws IOException {
        readFile(DataType.CATEGORY, fileCategories);
        readFile(DataType.AUTHOR, fileAuthors);
        readFile(DataType.BOOK, fileBooks);
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

    public static void readFile(DataType dataType, String file) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
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

    public static void readCategoryFile() throws IOException {
        String[] stringArray = splitLine();
        listOfCategories.add(new Category(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
    }

    public static void readAuthorFile() throws IOException {
        String[] stringArray = splitLine();
        listOfAuthors.add(new Author(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
    }

    public static void readBookFile() throws IOException {
        String[] stringArray = splitLine();

        int categoryId = Integer.parseInt(stringArray[stringArray.length - 1]);
        Category category = getCategory(listOfCategories, categoryId);

        String[] authorID = stringArray[5].split(",");
        List<Author> authorsInTheBook = new ArrayList<>();
        getListOfAuthorsInTheBook(listOfAuthors, authorID, authorsInTheBook);

        Book book = new Book(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2]),
                Integer.valueOf(stringArray[3]), stringArray[4], authorsInTheBook, category);
        listOfBooks.add(book);
    }

    private static Category getCategory(List<Category> listOfCategories, int categoryId) {
        return listOfCategories.stream()
                .filter(x -> x.getId() == categoryId)
                .findFirst().get();
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
}
