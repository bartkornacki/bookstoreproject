package functions;

import model.Book;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class BookFunctionsTest {

    List<Book> testListOfBooks;
    Book book1; //TODO to do setupa
    Book book2;
    Book book3;
    Book book4;
    Book book5;
    Book book6;

    @BeforeEach
    void setUp() {
        testListOfBooks = new ArrayList<>();
        book1 = new Book(11, "CTitle11",
                1231, 2010, "T", null, null);
        book2 = new Book(12, "Title12",
                1232, 2012, "T", null, null);
        book3 = new Book(13, "Title13",
                1233, 2000, "T", null, null);
        book4 = new Book(14, "CTitle14",
                1234, 2013, "T", null, null);
        book5 = new Book(15, "Title15",
                1235, 2015, "T", null, null);
        book6 = new Book(16, "Title16",
                1236, 2016, "T", null, null);
        testListOfBooks.add(book1);
        testListOfBooks.add(book2);
        testListOfBooks.add(book3);
        testListOfBooks.add(book4);
        testListOfBooks.add(book5);
        testListOfBooks.add(book6);
    }

    @Test
    void getBookByISBN1() {
        BookFunctions bookFunctions = new BookFunctions(); //TODO mozna raz w setupie
        Assert.assertEquals(book1, bookFunctions.getBookByISBNStream(testListOfBooks, 1231));
    }

    @Test
    void getBookByISBN2() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertNull(bookFunctions.getBookByISBNStream(testListOfBooks, 12311111));
    }

    @Test
    void getBookByISBN3() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(null, bookFunctions.getBookByISBNStream(null, 1231)); //TODO assertNull
    }

    @Test
    void getBookByISBN4() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book1, bookFunctions.getBookByISBNFor(testListOfBooks, 1231)); //TODO zamiast book1 to testList.get(x)
    }

    @Test
    void getBookByISBN5() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertNull(bookFunctions.getBookByISBNFor(testListOfBooks, 12311111));
    }

    @Test
    void getBookByISBN6() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(null, bookFunctions.getBookByISBNFor(null, 1231));
    }

    @Test
    void getTwoLastBooksFor1() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(book5);
        tempListOfBooks.add(book6);
        Assert.assertEquals(tempListOfBooks, bookFunctions.getTwoLastBooksFor(testListOfBooks));
    }

    @Test
    void getTwoLastBooksStream1() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(book5);
        tempListOfBooks.add(book6);
        Assert.assertEquals(tempListOfBooks, bookFunctions.getTwoLastBooksStream(testListOfBooks));
    }

    @Test
    void earliestReleasedBookFor() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book3, bookFunctions.earliestReleasedBookFor(testListOfBooks));
    }

    @Test
    void earliestReleasedBookStream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book3, bookFunctions.earliestReleasedBookStream(testListOfBooks));
    }

    @Test
    void latestReleasedBookFor() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book6, bookFunctions.latestReleasedBookFor(testListOfBooks));
    }

    @Test
    void latestReleasedBookStream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(book6, bookFunctions.latestReleasedBookStream(testListOfBooks));

    }

    @Test
    void sumOfAllYearsFor() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(12066, bookFunctions.sumOfAllYearsFor(testListOfBooks));
    }

    @Test
    void sumOfAllYearsStream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(12066, bookFunctions.sumOfAllYearsStream(testListOfBooks));
    }

    @Test
    void numberOfBooksReleasedPrior2007For() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(5, bookFunctions.numberOfBooksReleasedPrior2007For(testListOfBooks));
    }

    @Test
    void numberOfBooksReleasedPrior2007Stream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(5, bookFunctions.numberOfBooksReleasedPrior2007Stream(testListOfBooks));
    }

    @Test
    void checkIfAllBooksAreReleasedAfter2000For() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(false, bookFunctions.checkIfAllBooksAreReleasedAfter2000For(testListOfBooks)); //TODO assertfalse
    }

    @Test
    void checkIfAllBooksAreReleasedAfter2000Stream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(true, bookFunctions.checkIfAllBooksAreReleasedAfter2000Stream(testListOfBooks));
    }

    @Test
    void averageReleaseYearFor() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(2011, bookFunctions.averageReleaseYearFor(testListOfBooks), 0.01);
    }

    @Test
    void averageReleaseYearStream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(2011, bookFunctions.averageReleaseYearStream(testListOfBooks), 0.01);
    }

    @Test
    void checkIfAnyBookIsReleasedBefore2003For() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(true, bookFunctions.checkIfAnyBookIsReleasedBefore2003For(testListOfBooks));
    }

    @Test
    void checkIfAnyBookIsReleasedBefore2003Stream() {
        BookFunctions bookFunctions = new BookFunctions();
        Assert.assertEquals(true, bookFunctions.checkIfAnyBookIsReleasedBefore2003Stream(testListOfBooks));
    }

    @Test
    void getBooksStartingWithCAndReleasedAfter2007for() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(book1);
        tempListOfBooks.add(book4);
        Assert.assertEquals(tempListOfBooks, bookFunctions.getBooksStartingWithCAndReleasedAfter2007for(testListOfBooks));

    }

    @Test
    void getBooksStartingWithCAndReleasedAfter2007stream() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(book1);
        tempListOfBooks.add(book4);
        Assert.assertEquals(tempListOfBooks, bookFunctions.getBooksStartingWithCAndReleasedAfter2007stream(testListOfBooks));
    }

    @Test
    void add100YearsFor() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(book1);
        tempListOfBooks.add(book2);
        tempListOfBooks.add(book3);
        tempListOfBooks.add(book4);
        tempListOfBooks.add(book5);
        tempListOfBooks.add(book6);
        Assert.assertEquals(book3.getYear() + 100, bookFunctions.add100YearsFor(testListOfBooks).get(2).getYear());
    }

    @Test
    void add100YearsStream() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(book1);
        tempListOfBooks.add(book2);
        tempListOfBooks.add(book3);
        tempListOfBooks.add(book4);
        tempListOfBooks.add(book5);
        tempListOfBooks.add(book6);
        Assert.assertEquals(book3.getYear() + 100, bookFunctions.add100YearsStream(testListOfBooks).get(2).getYear());
    }

    @Test
    void getBooksDivisibleBy2For() {
        BookFunctions bookFunctions = new BookFunctions();
        List<String> tempListOfTitles = new ArrayList<>();
        tempListOfTitles.add(book1.getTitle());
        tempListOfTitles.add(book2.getTitle());
        tempListOfTitles.add(book3.getTitle());
        tempListOfTitles.add(book6.getTitle());
        Assert.assertEquals(tempListOfTitles, bookFunctions.getBooksDivisibleBy2For(testListOfBooks));
    }

    @Test
    void getBooksDivisibleBy2Stream() {
        BookFunctions bookFunctions = new BookFunctions();
        List<String> tempListOfTitles = new ArrayList<>();
        tempListOfTitles.add(book1.getTitle());
        tempListOfTitles.add(book2.getTitle());
        tempListOfTitles.add(book3.getTitle());
        tempListOfTitles.add(book6.getTitle());
        Assert.assertEquals(tempListOfTitles, bookFunctions.getBooksDivisibleBy2Stream(testListOfBooks));
    }

    @Test
    void getMapOfIsbnAndBooksFor() {
        BookFunctions bookFunctions = new BookFunctions();
        Map<Integer, Book> tempMapOfIsbnAndBooks = new TreeMap<>();
        tempMapOfIsbnAndBooks.put(1231, book1);
        tempMapOfIsbnAndBooks.put(1232, book2);
        tempMapOfIsbnAndBooks.put(1233, book3);
        tempMapOfIsbnAndBooks.put(1234, book4);
        tempMapOfIsbnAndBooks.put(1235, book5);
        tempMapOfIsbnAndBooks.put(1236, book6);
        Assert.assertEquals(tempMapOfIsbnAndBooks, bookFunctions.getMapOfIsbnAndBooksFor(testListOfBooks));
    }

    @Test
    void getMapOfIsbnAndBooksStream() {
        BookFunctions bookFunctions = new BookFunctions();
        Map<Integer, Book> tempMapOfIsbnAndBooks = new TreeMap<>();
        tempMapOfIsbnAndBooks.put(1231, book1);
        tempMapOfIsbnAndBooks.put(1232, book2);
        tempMapOfIsbnAndBooks.put(1233, book3);
        tempMapOfIsbnAndBooks.put(1234, book4);
        tempMapOfIsbnAndBooks.put(1235, book5);
        tempMapOfIsbnAndBooks.put(1236, book6);
        Assert.assertEquals(tempMapOfIsbnAndBooks, bookFunctions.getMapOfIsbnAndBooksStream(testListOfBooks));
    }

    @Test
    void sortBooksFromNewestFor() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(book6);
        tempListOfBooks.add(book5);
        tempListOfBooks.add(book4);
        tempListOfBooks.add(book2);
        tempListOfBooks.add(book1);
        tempListOfBooks.add(book3);
        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromNewestFor(testListOfBooks));
    }

    @Test
    void sortBooksFromNewestStream() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(book6);
        tempListOfBooks.add(book5);
        tempListOfBooks.add(book4);
        tempListOfBooks.add(book2);
        tempListOfBooks.add(book1);
        tempListOfBooks.add(book3);
        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromNewestStream(testListOfBooks));
    }

    @Test
    void sortBooksFromOldestFor() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(book3);
        tempListOfBooks.add(book1);
        tempListOfBooks.add(book2);
        tempListOfBooks.add(book4);
        tempListOfBooks.add(book5);
        tempListOfBooks.add(book6);
        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromOldestFor(testListOfBooks));
    }

    @Test
    void sortBooksFromOldestStream() {
        BookFunctions bookFunctions = new BookFunctions();
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(book3);
        tempListOfBooks.add(book1);
        tempListOfBooks.add(book2);
        tempListOfBooks.add(book4);
        tempListOfBooks.add(book5);
        tempListOfBooks.add(book6);
        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromOldestStream(testListOfBooks));
    }

    @Test
    void getListOfListsOfBooksFor() {
        BookFunctions bookFunctions = new BookFunctions();
        List<List<Book>> mainTempListOfBooks = new ArrayList<>();
        List<Book> firstTempListOfBooks = new ArrayList<>();
        List<Book> secondTempListOfBooks = new ArrayList<>();
        List<Book> thirdTempListOfBooks = new ArrayList<>();
        firstTempListOfBooks.add(book1);
        firstTempListOfBooks.add(book2);
        secondTempListOfBooks.add(book3);
        secondTempListOfBooks.add(book4);
        thirdTempListOfBooks.add(book5);
        thirdTempListOfBooks.add(book6);
        mainTempListOfBooks.add(firstTempListOfBooks);
        mainTempListOfBooks.add(secondTempListOfBooks);
        mainTempListOfBooks.add(thirdTempListOfBooks);
        System.out.println(testListOfBooks.get(2));
        Assert.assertEquals(mainTempListOfBooks, bookFunctions.getListOfListsOfBooksFor(testListOfBooks));

    }

    @Test
    void getListOfListsOfBooksStream() {
        BookFunctions bookFunctions = new BookFunctions();
        List<List<Book>> mainTempListOfBooks = new ArrayList<>();
        List<Book> firstTempListOfBooks = new ArrayList<>();
        List<Book> secondTempListOfBooks = new ArrayList<>();
        List<Book> thirdTempListOfBooks = new ArrayList<>();
        firstTempListOfBooks.add(book1);
        firstTempListOfBooks.add(book2);
        secondTempListOfBooks.add(book3);
        secondTempListOfBooks.add(book4);
        thirdTempListOfBooks.add(book5);
        thirdTempListOfBooks.add(book6);
        mainTempListOfBooks.add(firstTempListOfBooks);
        mainTempListOfBooks.add(secondTempListOfBooks);
        mainTempListOfBooks.add(thirdTempListOfBooks);
        Assert.assertEquals(mainTempListOfBooks, bookFunctions.getListOfListsOfBooksStream(testListOfBooks));
    }
}