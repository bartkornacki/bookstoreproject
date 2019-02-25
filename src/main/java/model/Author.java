package model;

public class Author {
    private int id;
    private String name;
    private int age;

    public Author(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return
                "\n*\t\tid:\t\t\t" + id +
                "\n*\t\tname:\t\t" + name +
                "\n*\t\tage:\t\t" + age;
    }
}
