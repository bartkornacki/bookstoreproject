package utils;

import model.Author;
import model.Category;

import java.util.List;
import java.util.Scanner;

public class ExtendTheList {
    public void addAuthor(){
        DataStorage dataStorage = new DataStorage();
        List<Author> listOfAuthors = dataStorage.getListOfAuthors();

        System.out.println(generateIDOfAuthor(listOfAuthors));
        Scanner in = new Scanner(System.in);
        System.out.println("Please provide the name of the author:");
        String name = in.next();
        System.out.println("Please provide the age of the author:");
        int age = in.nextInt();

        Author author = new Author(generateIDOfAuthor(listOfAuthors), name, age);
        listOfAuthors.add(author);
    }

    private int generateIDOfAuthor(List<Author> listOfAuthors) {
        return listOfAuthors.stream().mapToInt(x -> x.getId()).max().getAsInt() + 1;
    }

    public void addCategory(){
        DataStorage dataStorage = new DataStorage();
        List<Category> listOfCategories = dataStorage.getListOfCategories();

        System.out.println(generateIDOfCategory(listOfCategories));
        Scanner in = new Scanner(System.in);
        System.out.println("Please provide the name of the category:");
        String name = in.next();
        System.out.println("Please provide the priority of the category:");
        int priority = in.nextInt();

        Category category = new Category(generateIDOfCategory(listOfCategories), name, priority);
        listOfCategories.add(category);
    }

    private int generateIDOfCategory(List<Category> listOfCategories) {
        return listOfCategories.stream().mapToInt(x -> x.getId()).max().getAsInt() + 1;
    }
}
