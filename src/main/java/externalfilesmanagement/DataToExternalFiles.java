package externalfilesmanagement;

import model.Author;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class DataToExternalFiles {
    public void writeAuthorsToFile(List<Author> authorsList, String fileName) {
        String authorFileName = fileName;

        try {
            String str = authorsList
                    .stream()
                    .map(x -> x.getId() + ";" + x.getName() + ";" + x.getAge())
                    .collect(Collectors.joining("\n"));

            File file = new File(authorFileName);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();

            System.out.println("The file has been updated.");
        } catch (FileNotFoundException e) {
            System.out.println("The authors file wasn't found. Please ensure the file exists.");
        }
    }
}
