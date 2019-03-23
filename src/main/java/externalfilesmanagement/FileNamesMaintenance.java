package externalfilesmanagement;

public class FileNamesMaintenance {

    private String fileCategories = "src/main/resources/categories.csv";
    private String fileAuthors = "src/main/resources/authors.csv";
    private String fileBooks = "src/main/resources/books.csv";

    public String getFileCategories() {
        return fileCategories;
    }

    public String getFileAuthors() {
        return fileAuthors;
    }

    public String getFileBooks() {
        return fileBooks;
    }
}
