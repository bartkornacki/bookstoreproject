package utils;

import datastorage.DataStorage;
import model.Author;
import model.Category;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ExtendTheList {
    public void addAuthor() {
        DataStorage dataStorage = new DataStorage();
        List<Author> listOfAuthors = dataStorage.getListOfAuthors();

        System.out.println(generateIDOfAuthor(listOfAuthors));
        Scanner in = new Scanner(System.in);
        System.out.println("Please provide the name of the author:");
        String name = in.next();
        String age;
        int result = -1;
        do {
            System.out.println("Please provide the age of the author:");
            age = in.next();
//            isNumeric(CharSequence cs)
//            https://commons.apache.org/proper/commons-lang/javadocs/api-3.1/org/apache/commons/lang3/StringUtils.html
            if (age.matches("-?\\d+(\\.\\d+)?")) {
                result = Integer.parseInt(age);
            }
        } while ((result > 120) || (result < 0));
        Author author = new Author(generateIDOfAuthor(listOfAuthors), name, Integer.parseInt(age));
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

    public void changeCategoryName(List<Category> listOfCategories) {
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

                listOfCategories.get(id).setName(name);
            }
        } catch (InputMismatchException e) {
            System.out.println("The list of categories hasn't been modified, as unavailable option was chosen.");
        }
    }

    public boolean changeAuthorsAge(List<Author> listOfAuthors) {
        Scanner in = new Scanner(System.in);
        int id = 0;
        try {
            do {
                System.out.println("Please pick the author id to change his/her age:");
                listOfAuthors.stream().forEach(x -> System.out.println("\t\t"
                        + listOfAuthors.indexOf(x) + ": \t" + x.getName()));
                System.out.println("\t\t" + listOfAuthors.size() + ": \tExit");
                id = in.nextInt();
            } while (id > listOfAuthors.size() || id < 0);

            if (id != listOfAuthors.size()) {
                System.out.println("Please provide the updated age of the author:");
                int age = in.nextInt();

                listOfAuthors.get(id).setAge(age);
            }
            return true;
        } catch (InputMismatchException e) {
            System.out.println("The age of the author hasn't been modified, as unavailable option was chosen.");
        }
        return false;
    }
}
