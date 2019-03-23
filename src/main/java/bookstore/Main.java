package bookstore;

import externalfilesmanagement.FileNamesMaintenance;
import utils.MenuMaintenance;

public class Main {
    public static void main(String[] args) {
        MenuMaintenance menuMaintenance = new MenuMaintenance();
        FileNamesMaintenance fileNamesMaintenance = new FileNamesMaintenance();

        String fileCategories = fileNamesMaintenance.getFileCategories();
        String fileAuthors = fileNamesMaintenance.getFileAuthors();
        String fileBooks = fileNamesMaintenance.getFileBooks();

        menuMaintenance.menuNavigation(fileCategories, fileAuthors, fileBooks);
    }
}
