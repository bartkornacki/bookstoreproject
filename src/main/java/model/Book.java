package model;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Book implements Collection<List<Book>> {
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

    public void setIsbnNumber(int isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezel() {
        return bezel;
    }

    public void setBezel(String bezel) {
        this.bezel = bezel;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<List<Book>> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(List<Book> list) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends List<Book>> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
