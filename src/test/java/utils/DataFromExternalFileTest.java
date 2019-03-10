package utils;

import functions.BookFunctions;
import model.Author;
import model.Book;
import model.Category;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static javafx.scene.input.KeyCode.M;
import static org.junit.jupiter.api.Assertions.*;

class DataFromExternalFileTest {

    @BeforeEach
    void setUp() {
    } //TODO po co setup?

    @Test
    void readCategoryFile() {
        List<Category> tempListOfCategories = new ArrayList<>();
        Category category1 = new Category(1, "Java", 3);
        tempListOfCategories.add(category1);
        Category category2 = new Category(2, "Wzorce projektowe", 1);
        tempListOfCategories.add(category2);
        List<Category> listFromFile = new ArrayList<>();
        listFromFile = DataFromExternalFile.readCategoryFile("testCategories.csv");
        Assert.assertEquals(tempListOfCategories.get(1).getName(), listFromFile.get(1).getName());
    }

    @Test
    void readAuthorFile() {
        List<Author> tempListOfAuthors = new ArrayList<>();
        Author author1 = new Author(1, "Robert C. Martin", 32);
        tempListOfAuthors.add(author1);
        Author author2 = new Author(2, "Martin Fowler", 50);
        tempListOfAuthors.add(author2);
        List<Author> listFromFile = new ArrayList<>();
        listFromFile = DataFromExternalFile.readAuthorFile("testAuthors.csv");
        Assert.assertEquals(tempListOfAuthors.get(1).getName(), listFromFile.get(1).getName());
    }

    @Test
    void readBookFile() {



        List<Book> tempListOfBooks = new ArrayList<>();
        Book book1 = new Book(1, "Clean Code", 132350882, 2008,
                "T", null, null);
        tempListOfBooks.add(book1);
        Book book2 = new Book(2, "Effective Java (3rd Edition)", 134685997, 2018,
                "M",null, null);
        tempListOfBooks.add(book2);
        List<Book> listFromFile = new ArrayList<>();
        listFromFile = DataFromExternalFile.readBookFile("testBooks.csv");
        Assert.assertEquals(tempListOfBooks.get(1).getTitle(), listFromFile.get(1).getTitle());
        //TODO albo druga asercja albo zapisz 1 ksiazke.
    }
}