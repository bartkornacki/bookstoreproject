package utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataToExternalFilesTest {

    @BeforeEach
    void setUp() {
        String testString = "1;Robert C. Martin;32\n" +
                "2;Martin Fowler;50\n" +
                "3;Kent Beck;54\n" +
                "4;Joshua Bloch;34\n" +
                "5;Eric Freeman;41\n" +
                "6;Bert Bates;20\n" +
                "7;Kathy Sierra;67\n" +
                "8;Elisabeth Robson;42\n" +
                "9;asdasddas;432\n" +
                "10;asdasdasddas;432";
    }

    @Test
    void writeAuthorsToFile() {
    }
}