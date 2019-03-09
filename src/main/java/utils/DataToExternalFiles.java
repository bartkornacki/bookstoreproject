package utils;

import model.Author;
import model.Book;
import model.Category;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataToExternalFiles {

    public void writeAuthorsToFile() {
        String authorFileName = "authors.csv";
        DataStorage dataStorage = new DataStorage();

        try {
            String str = dataStorage.getListOfAuthors()
                    .stream()
                    .map(x -> x.getId() + ";" + x.getName() + ";" + x.getAge())
                    .collect(Collectors.joining("\n"));
            writeObject(authorFileName, str);
            System.out.println("The file has been updated.");
        } catch (FileNotFoundException e) {
            System.out.println("The authors file wasn't found. Please ensure the file exists.");
        }
    }

    public static void writeObject(String fileName, String text) throws FileNotFoundException {
        File file = new File(fileName);
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(text);
        printWriter.flush();
        printWriter.close();
    }
}
