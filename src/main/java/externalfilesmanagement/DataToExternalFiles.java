package externalfilesmanagement;

import model.Author;
import model.Book;
import model.Category;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class DataToExternalFiles {

    public void writeCategoriesToFile(List<Category> categoriesList, String fileName) {

        try {
            String str = categoriesList
                    .stream()
                    .map(x -> x.getId() + ";" + x.getName() + ";" + x.getPriority())
                    .collect(Collectors.joining("\n"));

            File file = new File(fileName);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();

            System.out.println("The file containing categories has been updated.");
        } catch (FileNotFoundException e) {
            System.out.println("An unexpected error has occured.");
        }
    }

    public void writeAuthorsToFile(List<Author> authorsList, String fileName) {

        try {
            String str = authorsList
                    .stream()
                    .map(x -> x.getId() + ";" + x.getName() + ";" + x.getAge())
                    .collect(Collectors.joining("\n"));

            File file = new File(fileName);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();

            System.out.println("The file containing authors has been updated.");
        } catch (FileNotFoundException e) {
            System.out.println("An unexpected error has occured.");
        }
    }


    public void writeBooksToFile(List<Book> booksList, String fileName) {

        try {
            String str = booksList
                    .stream()
                    .map(x -> x.getId() + ";" + x.getTitle() + ";" + x.getIsbnNumber() + ";"
                    +x.getYear() + ";" + x.getBezel() + ";" + x.getAuthors() + ";" + x.getCategory())
                    .collect(Collectors.joining("\n"));

            File file = new File(fileName);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();

            System.out.println("The file containing books has been updated.");
        } catch (FileNotFoundException e) {
            System.out.println("An unexpected error has occured.");
        }
    }
}
