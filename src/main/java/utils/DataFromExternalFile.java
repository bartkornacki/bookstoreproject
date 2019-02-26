package utils;

import model.Author;
import model.Book;
import model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataFromExternalFile {
    private static List<Book> listOfBooks = new ArrayList<>();
    private static List<Author> listOfAuthors = new ArrayList<>();
    private static List<Category> listOfCategories = new ArrayList<>();
    private static BufferedReader reader;

    public static void readDataFromExternalFiles(String fileCategories, String fileAuthors, String fileBooks) {
        try {
            readFile(DataType.CATEGORY, fileCategories);
        } catch (IOException e) {
            listOfCategories.add(new Category(1, "Category may be incorrect!", 1));
            listOfCategories.add(new Category(2, "Category may be incorrect!", 1));
            listOfCategories.add(new Category(3, "Category may be incorrect!", 1));
//            try {
//                String newCategory = "1;Java;3\n" +
//                        "2;Wzorce projektowe;1\n" +
//                        "3;Techniki programowania;21;Tekst;1\n";
//                saveNewObjectToTheNewFile(newCategory, fileCategories);
//                System.out.println("New file has been created");
//                readFile(DataType.CATEGORY, fileCategories);
//                System.out.println("New file has been read");
//            } catch (IOException e1) {
//                System.out.println("Wrong turn! Go back to school!");
//            }
        }
        try {
            readFile(DataType.AUTHOR, fileAuthors);
        } catch (IOException e) {
            listOfAuthors.add(new Author(1, "Author may be incorrect!", 0));
            listOfAuthors.add(new Author(2, "Author may be incorrect!", 0));
            listOfAuthors.add(new Author(3, "Author may be incorrect!", 0));
            listOfAuthors.add(new Author(4, "Author may be incorrect!", 0));
            listOfAuthors.add(new Author(5, "Author may be incorrect!", 0));
            listOfAuthors.add(new Author(6, "Author may be incorrect!", 0));
            listOfAuthors.add(new Author(7, "Author may be incorrect!", 0));
            listOfAuthors.add(new Author(8, "Author may be incorrect!", 0));
        }
        try {
            readFile(DataType.BOOK, fileBooks);
        } catch (IOException e) {
            listOfBooks.add(new Book(1, "Title may be incorrect!", 1, 0, null, null, null));
        }
        DataPresenting.showData(listOfBooks, listOfAuthors, listOfCategories);
    }

    private static void saveNewObjectToTheNewFile(String newInput, String fileCategories) throws FileNotFoundException {
        File file = new File(fileCategories);
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(newInput);
        printWriter.flush();
        printWriter.close();
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
        reader = new DataFromExternalFile().openAnExternalFile(file);
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
        Category category = getCategory(stringArray[stringArray.length - 1]);
        List<Author> authorsInTheBook = getAuthors(stringArray[5]);

        Book book = new Book(
                Integer.valueOf(stringArray[0]), stringArray[1], Integer.valueOf(stringArray[2]),
                Integer.valueOf(stringArray[3]), stringArray[4], authorsInTheBook, category);
        listOfBooks.add(book);
    }

    private static Category getCategory(String s) {
        int categoryId = Integer.parseInt(s);
        return listOfCategories.stream()
                .filter(x -> x.getId() == categoryId)
                .findFirst().get();
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
