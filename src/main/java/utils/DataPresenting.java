package utils;

import model.Author;
import model.Book;
import model.Category;

import java.util.List;

public class DataPresenting {
    public void showCategories(List<Category> listOfCategories) {
        DataPresenting dataPresenting = new DataPresenting(); //TODO dlaczego tworzymy 3 razy? DLaczego w ogole to tworzymy?
        for (Category c : listOfCategories) {
            System.out.println(c.toString());
        }
    }

    public void showAuthors(List<Author> listOfAuthors) {
        DataPresenting dataPresenting = new DataPresenting();
        for (Author a : listOfAuthors) {
            System.out.println(a.toString());
        }
    }

    public void showBooks(List<Book> listOfBooks) {
        DataPresenting dataPresenting = new DataPresenting();
        for (Book b : listOfBooks) {
            System.out.println(b.toString());
        }
    }
}
