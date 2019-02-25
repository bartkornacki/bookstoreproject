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

    public static List<Category> categoryFileReader(String file) throws IOException {
        reader = new ExternalFile().fileOpener(file);
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

    public static List<Author> authorFileReader(String file) throws IOException {
        reader = new ExternalFile().fileOpener(file);

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

    public static List<Book> bookFileReader(String file, List<Category> listOfCategories, List<Author> listOfAuthors) throws IOException {
        reader = new ExternalFile().fileOpener(file);

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
                    if (listOfAuthor.getId() == Integer.parseInt(authorIDs[i])){
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

    private BufferedReader fileOpener(String file) throws FileNotFoundException {
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is);
        return new BufferedReader(isr);
    }

    public static void categoriesReader(List<Category> listOfCategories) {
        for (Category c : listOfCategories) {
            System.out.println("*******************");
            System.out.println("Title of the categories: " + c.getName());
            System.out.println("Title of the categories: " + c.getId());
            System.out.println("Title of the categories: " + c.getPriority());
            System.out.println("*******************");
        }
    }

    public static void authorsReader(List<Author> listOfAuthors) {
        for (Author a : listOfAuthors) {
            System.out.println("*******************");
            System.out.println("Title of the authors: " + a.getName());
            System.out.println("*******************");
        }
    }

    public static void booksReader(List<Book> listOfBooks) {
        for (Book b : listOfBooks) {
//            System.out.println("*******************");
            System.out.println(b.toString());
        }
    }
}
