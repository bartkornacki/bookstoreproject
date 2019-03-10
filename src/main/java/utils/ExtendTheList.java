package utils;

import model.Author;
import model.Book;
import model.Category;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExtendTheList {
    public void addAuthor() {
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

    public void addCategory() {
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

    public List<Category> changeCategoryName(List<Category> listOfCategories) {

        Scanner in = new Scanner(System.in);
        int id = 0;
        try {
            do {
                System.out.println("Please pick the category index to be replaced:");
                listOfCategories.stream().forEach(x -> System.out.println("\t\t"
                        + listOfCategories.indexOf(x) + ": \t" + x.getName()));
                System.out.println("\t\t" + listOfCategories.size() + ": \tExit");
                id = in.nextInt();
            } while (id > listOfCategories.size() || id < 0);

            if (id != listOfCategories.size()) {

                int priority = listOfCategories.get(id).getPriority();
                System.out.println("Please provide new name of the category:");
                String name = in.next();

                listOfCategories.remove(id); //TODO zamist 2 linijek jedna
                listOfCategories.add(id, new Category(id + 1, name, priority));
            }
        } catch (InputMismatchException e) {
            System.out.println("The list of categories hasn't been modified, as unavailable option was chosen.");
        }
        return listOfCategories; //TODO nie powinna nic zwracac.
    }
}
