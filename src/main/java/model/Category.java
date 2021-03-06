package model;

public class Category {
    private int id;
    private String name;
    private int priority;

    public Category(int id, String name, int priority) {
        this.id = id;
        this.name = name;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "\tid:\t\t\t" + id +
                "\n*\t\tname:\t\t" + name +
                "\n*\t\tpriority\t" + priority;
    }
}
