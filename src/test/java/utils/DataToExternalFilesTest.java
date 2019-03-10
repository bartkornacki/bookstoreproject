package utils;

import model.Author;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataToExternalFilesTest {
//
//    @BeforeEach
//    void setUp() {
//        DataStorage dataStorage = new DataStorage();
//
//    }

    @Test
    void writeAuthorsToFile() {
        List<Author> tempListOfAuthors = new ArrayList<>();
        Author author1 = new Author(1, "Robert1", 32);
        tempListOfAuthors.add(author1);
        Author author2 = new Author(2, "Robert2", 50);
        tempListOfAuthors.add(author2);
        Author author3 = new Author(3, "Robert3", 54);
        tempListOfAuthors.add(author3);
        List<Author> listFromFile = new ArrayList<>();

        DataToExternalFiles dataToExternalFiles = new DataToExternalFiles();


        dataToExternalFiles.writeAuthorsToFile(tempListOfAuthors, "test.csv");
        listFromFile = DataFromExternalFile.readAuthorFile("test.csv");

        Assert.assertEquals(tempListOfAuthors.get(2).getName(), listFromFile.get(2).getName());
    }
}