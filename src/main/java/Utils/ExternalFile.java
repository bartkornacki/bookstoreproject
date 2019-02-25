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

        showData(listOfBooks, listOfAuthors, listOfCategories);
    }

    private static void showData(List<Book> listOfBooks, List<Author> listOfAuthors, List<Category> listOfCategories) {
        showCategories(listOfCategories);
        showAuthors(listOfAuthors);
        showBooks(listOfBooks);
    }

    public static void showCategories(List<Category> listOfCategories) {
        for (Category c : listOfCategories) {
            System.out.println(c.toString());
        }
    }

    public static void showAuthors(List<Author> listOfAuthors) {
        for (Author a : listOfAuthors) {
            System.out.println(a.toString());
        }
    }

    public static void showBooks(List<Book> listOfBooks) {
        for (Book b : listOfBooks) {
            System.out.println(b.toString());
        }
    }

    private BufferedReader openAnExternalFile(String file) throws FileNotFoundException {
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is);
        return new BufferedReader(isr);
    }

    public static List<Category> readCategoryFile(String file) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
        while (reader.ready()) {
            String line = reader.readLine();
            tempList.add(line);
            String[] tempStringArray = line.split(";");

            Category category = new Category(
                    Integer.valueOf(tempStringArray[0]), tempStringArray[1], Integer.valueOf(tempStringArray[2]));
            listOfCategories.add(category);
        }
        reader.close();
        return listOfCategories;
    }

    public static List<Author> readAuthorFile(String file) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
        while (reader.ready()) {
            String line = reader.readLine();
            tempList.add(line);
            String[] tempStringArray = line.split(";");

            Author author = new Author(
                    Integer.valueOf(tempStringArray[0]), tempStringArray[1], Integer.valueOf(tempStringArray[2]));
            listOfAuthors.add(author);
        }
        reader.close();
        return listOfAuthors;
    }

    public static List<Book> readBookFile(String file, List<Category> listOfCategories, List<Author> listOfAuthors) throws IOException {
        reader = new ExternalFile().openAnExternalFile(file);
        while (reader.ready()) {
            String line = reader.readLine();
            tempList.add(line);
            String[] tempStringArray = line.split(";");

            int categoryId = Integer.parseInt(tempStringArray[tempStringArray.length - 1]);
            Category category = listOfCategories.stream()
                    .filter(x -> x.getId() == categoryId)
                    .findFirst().get();

            String[] authorIDs = tempStringArray[5].split(",");
            List<Integer> listOfAuthorIDs = new ArrayList<>();
            for (int i = 0; i < authorIDs.length; i++) {
                listOfAuthorIDs.add(Integer.parseInt(String.valueOf(authorIDs[i])));
            }

            List<Author> listOfAuthorsInTheBook = new ArrayList<>();

            for (int i = 0; i < authorIDs.length; i++) {
                for (Author listOfAuthor : listOfAuthors) {
                    if (listOfAuthor.getId() == Integer.parseInt(authorIDs[i])) {
                        listOfAuthorsInTheBook.add(listOfAuthor);
                    }
                }
            }

//            int authorID = Integer.parseInt(authorIDs[authorIDs.length - 1]);
//            for (int i = 0; i < authorIDs.length; i++) {
//                listOfAuthorsInTheBook = listOfAuthors.stream()
//                        .filter(x -> x.getId() == authorID)
//                        .collect(Collectors.toList());
//                        .findFirst().get();
//            }

            Book book = new Book(
                    Integer.valueOf(tempStringArray[0]), tempStringArray[1], Integer.valueOf(tempStringArray[2]),
                    Integer.valueOf(tempStringArray[3]), tempStringArray[4], listOfAuthorsInTheBook, category);
            listOfBooks.add(book);
        }
        reader.close();
        return listOfBooks;
    }
}
