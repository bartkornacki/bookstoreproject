package utils;

import model.Author;

import java.util.List;
import java.util.Scanner;

public class ExtendTheList {
    public void addAuthor(){
        DataStorage dataStorage = new DataStorage();
        List<Author> listOfAuthors = dataStorage.getListOfAuthorsFromFile();

        System.out.println(generateID(listOfAuthors));
        Scanner in = new Scanner(System.in);
        System.out.println("Please provide the name of the author:");
        String name = in.next();
        System.out.println("Please provide the age of the author:");
        int age = in.nextInt();

        Author author = new Author(generateID(listOfAuthors), name, age);
        listOfAuthors.add(author);
//        return author;
    }

    private int generateID(List<Author> listOfAuthors) {
        return listOfAuthors.stream().mapToInt(x -> x.getId()).max().getAsInt() + 1;
    }

}
