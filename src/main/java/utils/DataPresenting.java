package utils;

import model.Author;
import model.Book;
import model.Category;

import java.util.List;

public class DataPresenting {
    static void showData(List<Book> listOfBooks, List<Author> listOfAuthors, List<Category> listOfCategories) {
        DataPresenting dataPresenting = new DataPresenting();
        dataPresenting.showBooks(listOfBooks);
    }

    public void showCategories(List<Category> listOfCategories) {
        for (Category c : listOfCategories) {
            System.out.println(c.toString());
        }
    }

    public void showAuthors(List<Author> listOfAuthors) {
        for (Author a : listOfAuthors) {
            System.out.println(a.toString());
        }
    }

    public void showBooks(List<Book> listOfBooks) {
        for (Book b : listOfBooks) {
            System.out.println(b.toString());
        }
    }
}
