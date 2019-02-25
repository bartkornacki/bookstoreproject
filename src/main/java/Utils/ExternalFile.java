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
        List<Book> listOfBooks;
        List<Author> listOfAuthors;
        List<Category> listOfCategories;

        listOfCategories = readCategoryFile(fileCategories);
        listOfAuthors = readAuthorFile(fileAuthors);
        listOfBooks = readBookFile(fileBooks, listOfCategories, listOfAuthors);

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

    public static List<Category> readCategoryFile(String file) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
        while (reader.ready()) {
            String[] stringArray = splitLine();
            listOfCategories.add(new Category(
                    Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
        }
        reader.close();
        return listOfCategories;
    }

    public static List<Author> readAuthorFile(String file) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
        while (reader.ready()) {
            String[] stringArray = splitLine();
            listOfAuthors.add(new Author(
                    Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2])));
        }
        reader.close();
        return listOfAuthors;
    }

    public static List<Book> readBookFile(String file, List<Category> listOfCategories, List<Author> listOfAuthors) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
        while (reader.ready()) {
            String[] stringArray = splitLine();
            fulfillListOfBooks(listOfCategories, listOfAuthors, stringArray);
        }
        reader.close();
        return listOfBooks;
    }

    private static void fulfillListOfBooks(List<Category> listOfCategories, List<Author> listOfAuthors, String[] stringArray) {
        int categoryId = Integer.parseInt(stringArray[stringArray.length - 1]);
        String[] authorID = stringArray[5].split(",");
        List<Author> authorsInTheBook = new ArrayList<>();

        Category category = listOfCategories.stream()
                .filter(x -> x.getId() == categoryId)
                .findFirst().get();

        for (int i = 0; i < authorID.length; i++) {
            for (Author listOfAuthor : listOfAuthors) {
                if (listOfAuthor.getId() == Integer.parseInt(authorID[i])) {
                    authorsInTheBook.add(listOfAuthor);
                }
            }
        }

        Book book = new Book(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2]),
                Integer.valueOf(stringArray[3]), stringArray[4], authorsInTheBook, category);
        listOfBooks.add(book);
    }
}
