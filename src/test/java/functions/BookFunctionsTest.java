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
    BookFunctions bookFunctions;

    @BeforeEach
    void setUp() {
        bookFunctions = new BookFunctions();
        testListOfBooks = new ArrayList<>();
        testListOfBooks.add(new Book(11, "CTitle11",
                1231, 2010, "T", null, null));
        testListOfBooks.add(new Book(12, "Title12",
                1232, 2012, "T", null, null));
        testListOfBooks.add(new Book(13, "Title13",
                1233, 2000, "T", null, null));
        testListOfBooks.add(new Book(14, "CTitle14",
                1234, 2013, "T", null, null));
        testListOfBooks.add(new Book(15, "Title15",
                1235, 2015, "T", null, null));
        testListOfBooks.add(new Book(16, "Title16",
                1236, 2016, "T", null, null));
    }

    @Test
    void getBookByISBN1() {
        Assert.assertEquals(testListOfBooks.get(0), bookFunctions.getBookByISBNStream(testListOfBooks, 1231));
    }

    @Test
    void getBookByISBN2() {
        Assert.assertNull(bookFunctions.getBookByISBNStream(testListOfBooks, 12311111));
    }

    @Test
    void getBookByISBN3() {
        Assert.assertNull(bookFunctions.getBookByISBNStream(null, 1231));
    }

    @Test
    void getBookByISBN4() {
        Assert.assertEquals(testListOfBooks.get(0), bookFunctions.getBookByISBNFor(testListOfBooks, 1231));
    }

    @Test
    void getBookByISBN5() {
        Assert.assertNull(bookFunctions.getBookByISBNFor(testListOfBooks, 12311111));
    }

    @Test
    void getBookByISBN6() {
        Assert.assertNull(bookFunctions.getBookByISBNFor(null, 1231));
    }

    @Test
    void getTwoLastBooksFor1() {
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(testListOfBooks.get(4));
        tempListOfBooks.add(testListOfBooks.get(5));
        Assert.assertEquals(tempListOfBooks, bookFunctions.getTwoLastBooksFor(testListOfBooks));
    }

    @Test
    void getTwoLastBooksStream1() {
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(testListOfBooks.get(4));
        tempListOfBooks.add(testListOfBooks.get(5));
        Assert.assertEquals(tempListOfBooks, bookFunctions.getTwoLastBooksStream(testListOfBooks));
    }

    @Test
    void earliestReleasedBookFor() {
        Assert.assertEquals(testListOfBooks.get(2), bookFunctions.earliestReleasedBookFor(testListOfBooks));
    }

    @Test
    void earliestReleasedBookStream() {
        Assert.assertEquals(testListOfBooks.get(2), bookFunctions.earliestReleasedBookStream(testListOfBooks));
    }

    @Test
    void latestReleasedBookFor() {
        Assert.assertEquals(testListOfBooks.get(5), bookFunctions.latestReleasedBookFor(testListOfBooks));
    }

    @Test
    void latestReleasedBookStream() {
        Assert.assertEquals(testListOfBooks.get(5), bookFunctions.latestReleasedBookStream(testListOfBooks));

    }

    @Test
    void sumOfAllYearsFor() {
        Assert.assertEquals(12066, bookFunctions.sumOfAllYearsFor(testListOfBooks));
    }

    @Test
    void sumOfAllYearsStream() {
        Assert.assertEquals(12066, bookFunctions.sumOfAllYearsStream(testListOfBooks));
    }

    @Test
    void numberOfBooksReleasedPrior2007For() {
        Assert.assertEquals(5, bookFunctions.numberOfBooksReleasedPrior2007For(testListOfBooks));
    }

    @Test
    void numberOfBooksReleasedPrior2007Stream() {
        Assert.assertEquals(5, bookFunctions.numberOfBooksReleasedPrior2007Stream(testListOfBooks));
    }

    @Test
    void checkIfAllBooksAreReleasedAfter2000For() {
        Assert.assertFalse(bookFunctions.checkIfAllBooksAreReleasedAfter2000For(testListOfBooks));
    }

    @Test
    void checkIfAllBooksAreReleasedAfter2000Stream() {
        Assert.assertTrue(bookFunctions.checkIfAllBooksAreReleasedAfter2000Stream(testListOfBooks));
    }

    @Test
    void averageReleaseYearFor() {
        Assert.assertEquals(2011, bookFunctions.averageReleaseYearFor(testListOfBooks), 0.01);
    }

    @Test
    void averageReleaseYearStream() {
        Assert.assertEquals(2011, bookFunctions.averageReleaseYearStream(testListOfBooks), 0.01);
    }

    @Test
    void checkIfAnyBookIsReleasedBefore2003For() {
        Assert.assertTrue(bookFunctions.checkIfAnyBookIsReleasedBefore2003For(testListOfBooks));
    }

    @Test
    void checkIfAnyBookIsReleasedBefore2003Stream() {
        Assert.assertTrue(bookFunctions.checkIfAnyBookIsReleasedBefore2003Stream(testListOfBooks));
    }

    @Test
    void getBooksStartingWithCAndReleasedAfter2007for() {
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(testListOfBooks.get(0));
        tempListOfBooks.add(testListOfBooks.get(3));
        Assert.assertEquals(tempListOfBooks, bookFunctions.getBooksStartingWithCAndReleasedAfter2007for(testListOfBooks));

    }

    @Test
    void getBooksStartingWithCAndReleasedAfter2007stream() {
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(testListOfBooks.get(0));
        tempListOfBooks.add(testListOfBooks.get(3));
        Assert.assertEquals(tempListOfBooks, bookFunctions.getBooksStartingWithCAndReleasedAfter2007stream(testListOfBooks));
    }

    @Test
    void add100YearsFor() {
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(testListOfBooks.get(0));
        tempListOfBooks.add(testListOfBooks.get(1));
        tempListOfBooks.add(testListOfBooks.get(2));
        tempListOfBooks.add(testListOfBooks.get(3));
        tempListOfBooks.add(testListOfBooks.get(4));
        tempListOfBooks.add(testListOfBooks.get(5));
        Assert.assertEquals(testListOfBooks.get(2).getYear() + 100,
                bookFunctions.add100YearsFor(testListOfBooks).get(2).getYear());
    }

    @Test
    void add100YearsStream() {
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(testListOfBooks.get(0));
        tempListOfBooks.add(testListOfBooks.get(1));
        tempListOfBooks.add(testListOfBooks.get(2));
        tempListOfBooks.add(testListOfBooks.get(3));
        tempListOfBooks.add(testListOfBooks.get(4));
        tempListOfBooks.add(testListOfBooks.get(5));
        Assert.assertEquals(testListOfBooks.get(2).getYear() + 100,
                bookFunctions.add100YearsStream(testListOfBooks).get(2).getYear());
    }

    @Test
    void getBooksDivisibleBy2For() {
        List<String> tempListOfTitles = new ArrayList<>();
        tempListOfTitles.add(testListOfBooks.get(0).getTitle());
        tempListOfTitles.add(testListOfBooks.get(1).getTitle());
        tempListOfTitles.add(testListOfBooks.get(2).getTitle());
        tempListOfTitles.add(testListOfBooks.get(5).getTitle());
        Assert.assertEquals(tempListOfTitles, bookFunctions.getBooksDivisibleBy2For(testListOfBooks));
    }

    @Test
    void getBooksDivisibleBy2Stream() {
        List<String> tempListOfTitles = new ArrayList<>();
        tempListOfTitles.add(testListOfBooks.get(0).getTitle());
        tempListOfTitles.add(testListOfBooks.get(1).getTitle());
        tempListOfTitles.add(testListOfBooks.get(2).getTitle());
        tempListOfTitles.add(testListOfBooks.get(5).getTitle());
        Assert.assertEquals(tempListOfTitles, bookFunctions.getBooksDivisibleBy2Stream(testListOfBooks));
    }

    @Test
    void getMapOfIsbnAndBooksFor() {
        Map<Integer, Book> tempMapOfIsbnAndBooks = new TreeMap<>();
        tempMapOfIsbnAndBooks.put(1231, testListOfBooks.get(0));
        tempMapOfIsbnAndBooks.put(1232, testListOfBooks.get(1));
        tempMapOfIsbnAndBooks.put(1233, testListOfBooks.get(2));
        tempMapOfIsbnAndBooks.put(1234, testListOfBooks.get(3));
        tempMapOfIsbnAndBooks.put(1235, testListOfBooks.get(4));
        tempMapOfIsbnAndBooks.put(1236, testListOfBooks.get(5));
        Assert.assertEquals(tempMapOfIsbnAndBooks, bookFunctions.getMapOfIsbnAndBooksFor(testListOfBooks));
    }

    @Test
    void getMapOfIsbnAndBooksStream() {
        Map<Integer, Book> tempMapOfIsbnAndBooks = new TreeMap<>();
        tempMapOfIsbnAndBooks.put(1231, testListOfBooks.get(0));
        tempMapOfIsbnAndBooks.put(1232, testListOfBooks.get(1));
        tempMapOfIsbnAndBooks.put(1233, testListOfBooks.get(2));
        tempMapOfIsbnAndBooks.put(1234, testListOfBooks.get(3));
        tempMapOfIsbnAndBooks.put(1235, testListOfBooks.get(4));
        tempMapOfIsbnAndBooks.put(1236, testListOfBooks.get(5));
        Assert.assertEquals(tempMapOfIsbnAndBooks, bookFunctions.getMapOfIsbnAndBooksStream(testListOfBooks));
    }

    @Test
    void sortBooksFromNewestFor() {
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(testListOfBooks.get(5));
        tempListOfBooks.add(testListOfBooks.get(4));
        tempListOfBooks.add(testListOfBooks.get(3));
        tempListOfBooks.add(testListOfBooks.get(1));
        tempListOfBooks.add(testListOfBooks.get(0));
        tempListOfBooks.add(testListOfBooks.get(2));
        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromNewestFor(testListOfBooks));
    }

    @Test
    void sortBooksFromNewestStream() {
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(testListOfBooks.get(5));
        tempListOfBooks.add(testListOfBooks.get(4));
        tempListOfBooks.add(testListOfBooks.get(3));
        tempListOfBooks.add(testListOfBooks.get(1));
        tempListOfBooks.add(testListOfBooks.get(0));
        tempListOfBooks.add(testListOfBooks.get(2));
        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromNewestStream(testListOfBooks));
    }

    @Test
    void sortBooksFromOldestFor() {
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(testListOfBooks.get(2));
        tempListOfBooks.add(testListOfBooks.get(0));
        tempListOfBooks.add(testListOfBooks.get(1));
        tempListOfBooks.add(testListOfBooks.get(3));
        tempListOfBooks.add(testListOfBooks.get(4));
        tempListOfBooks.add(testListOfBooks.get(5));
        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromOldestFor(testListOfBooks));
    }

    @Test
    void sortBooksFromOldestStream() {
        List<Book> tempListOfBooks = new ArrayList<>();
        tempListOfBooks.add(testListOfBooks.get(2));
        tempListOfBooks.add(testListOfBooks.get(0));
        tempListOfBooks.add(testListOfBooks.get(1));
        tempListOfBooks.add(testListOfBooks.get(3));
        tempListOfBooks.add(testListOfBooks.get(4));
        tempListOfBooks.add(testListOfBooks.get(5));
        Assert.assertEquals(tempListOfBooks, bookFunctions.sortBooksFromOldestStream(testListOfBooks));
    }

    @Test
    void getListOfListsOfBooksFor() {
        List<List<Book>> mainTempListOfBooks = new ArrayList<>();
        List<Book> firstTempListOfBooks = new ArrayList<>();
        List<Book> secondTempListOfBooks = new ArrayList<>();
        List<Book> thirdTempListOfBooks = new ArrayList<>();
        firstTempListOfBooks.add(testListOfBooks.get(0));
        firstTempListOfBooks.add(testListOfBooks.get(1));
        secondTempListOfBooks.add(testListOfBooks.get(2));
        secondTempListOfBooks.add(testListOfBooks.get(3));
        thirdTempListOfBooks.add(testListOfBooks.get(4));
        thirdTempListOfBooks.add(testListOfBooks.get(5));
        mainTempListOfBooks.add(firstTempListOfBooks);
        mainTempListOfBooks.add(secondTempListOfBooks);
        mainTempListOfBooks.add(thirdTempListOfBooks);
        Assert.assertEquals(mainTempListOfBooks, bookFunctions.getListOfListsOfBooksFor(testListOfBooks));

    }

    @Test
    void getListOfListsOfBooksStream() {
        List<List<Book>> mainTempListOfBooks = new ArrayList<>();
        List<Book> firstTempListOfBooks = new ArrayList<>();
        List<Book> secondTempListOfBooks = new ArrayList<>();
        List<Book> thirdTempListOfBooks = new ArrayList<>();
        firstTempListOfBooks.add(testListOfBooks.get(0));
        firstTempListOfBooks.add(testListOfBooks.get(1));
        secondTempListOfBooks.add(testListOfBooks.get(2));
        secondTempListOfBooks.add(testListOfBooks.get(3));
        thirdTempListOfBooks.add(testListOfBooks.get(4));
        thirdTempListOfBooks.add(testListOfBooks.get(5));
        mainTempListOfBooks.add(firstTempListOfBooks);
        mainTempListOfBooks.add(secondTempListOfBooks);
        mainTempListOfBooks.add(thirdTempListOfBooks);
        Assert.assertEquals(mainTempListOfBooks, bookFunctions.getListOfListsOfBooksStream(testListOfBooks));
    }
}