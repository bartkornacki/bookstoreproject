package model;

import java.util.List;

public class Book {
    private int id;
    private String title;
    private int isbnNumber;
    private int year;
    private String bezel;
    private List<Author> authors;
    private Category category;

    public Book(int id, String title, int isbnNumber, int year, String bezel, List<Author> authors, Category category) {
        this.id = id;
        this.title = title;
        this.isbnNumber = isbnNumber;
        this.year = year;
        this.bezel = bezel;
        this.authors = authors;
        this.category = category;
    }

    public int getIsbnNumber() {
        return isbnNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getBezel() {
        return bezel;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Category getCategory() {
        return category;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "\n*********************************************************" +
                "\n*\tBook:" +
                "\n*\tid:\t\t\t\t" + id +
                "\n*\ttitle:\t\t\t" + title +
                "\n*\tISBN:\t\t\t" + isbnNumber +
                "\n*\tyear:\t\t\t" + year +
                "\n*\tbezel:\t\t\t" + bezel +
                "\n*\tauthors:\n*\t" + authors +
                "\n*\tcategory:\n*\t" + category +
                "\n*********************************************************";
    }
}
