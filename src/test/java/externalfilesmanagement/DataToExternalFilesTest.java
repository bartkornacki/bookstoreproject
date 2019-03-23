package externalfilesmanagement;

import model.Author;
import model.Book;
import model.Category;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DataToExternalFilesTest {

    @Test
    void writeCategoriesToFile() {
        List<Category> tempListOfCategories = new ArrayList<>();
        Category category1 = new Category(1, "Java", 3);
        tempListOfCategories.add(category1);
        Category category2 = new Category(2, "Wzorce projektowe", 2);
        tempListOfCategories.add(category2);
        List<Category> listFromFile = new ArrayList<>();

        DataToExternalFiles dataToExternalFiles = new DataToExternalFiles();

        dataToExternalFiles.writeCategoriesToFile(tempListOfCategories, "src/test/resources/testCategories.csv");
        listFromFile = DataFromExternalFile.readCategoryFile("src/test/resources/testCategories.csv");

        Assert.assertEquals(tempListOfCategories.get(0).getName(), listFromFile.get(0).getName());
        Assert.assertEquals(tempListOfCategories.get(1).getName(), listFromFile.get(1).getName());
    }

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

        dataToExternalFiles.writeAuthorsToFile(tempListOfAuthors, "src/test/resources/testAuthors.csv");
        listFromFile = DataFromExternalFile.readAuthorFile("src/test/resources/testAuthors.csv");

        Assert.assertEquals(tempListOfAuthors.get(0).getName(), listFromFile.get(0).getName());
        Assert.assertEquals(tempListOfAuthors.get(1).getName(), listFromFile.get(1).getName());
        Assert.assertEquals(tempListOfAuthors.get(2).getName(), listFromFile.get(2).getName());
    }

    @Test
    void writeBooksToFile() {
        List<Book> tempListOfBooks = new ArrayList<>();
        Book book1 = new Book(1, "Clean Code", 132350882, 2008,
                "T", null, null);
        tempListOfBooks.add(book1);
        Book book2 = new Book(2, "Effective Java (3rd Edition)", 134685997, 2018,
                "M", null, null);
        tempListOfBooks.add(book2);
        List<Book> listFromFile = new ArrayList<>();

        DataToExternalFiles dataToExternalFiles = new DataToExternalFiles();

        dataToExternalFiles.writeBooksToFile(tempListOfBooks, "src/test/resources/testBooks.csv");
        listFromFile = DataFromExternalFile.readBookFile("src/test/resources/testBooks.csv");

        Assert.assertEquals(tempListOfBooks.get(0).getTitle(), listFromFile.get(0).getTitle());
        Assert.assertEquals(tempListOfBooks.get(1).getTitle(), listFromFile.get(1).getTitle());
    }
}