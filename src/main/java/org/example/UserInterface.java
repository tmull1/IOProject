package org.example;

import java.util.List;
import java.util.Scanner;

/**
 * Class to provide a command-line interface for interacting with the file manager.
 */
public class UserInterface {

    private FileOperations fileOps = new FileOperations();
    private DirectoryOperations dirOps = new DirectoryOperations();
    private SearchOperations searchOps = new SearchOperations();
    private Scanner scanner = new Scanner(System.in);

    /**
     * Starts the command-line interface for the file manager.
     */
    public void start() {
        while (true) {
            displayMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    listDirectoryContents();
                    break;
                case "2":
                    copyFile();
                    break;
                case "3":
                    moveFile();
                    break;
                case "4":
                    deleteFile();
                    break;
                case "5":
                    createDirectory();
                    break;
                case "6":
                    deleteDirectory();
                    break;
                case "7":
                    searchFiles();
                    break;
                case "0":
                    exitApplication();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    /**
     * Displays the main menu for the file manager.
     */
    private void displayMenu() {
        System.out.println("\nFile Manager Menu:");
        System.out.println("1. Display directory contents");
        System.out.println("2. Copy file");
        System.out.println("3. Move file");
        System.out.println("4. Delete file");
        System.out.println("5. Create directory");
        System.out.println("6. Delete directory");
        System.out.println("7. Search files");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }

    /**
     * Lists the contents of a specified directory.
     */
    private void listDirectoryContents() {
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        dirOps.listDirectoryContents(path);
    }

    /**
     * Copies a file from one location to another.
     */
    private void copyFile() {
        System.out.print("Enter source file path: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination file path: ");
        String destination = scanner.nextLine();
        try {
            fileOps.copyFile(source, destination);
        } catch (Exception e) {
            LoggerUtility.logError("Error copying file: " + e.getMessage());
        }
    }

    /**
     * Moves a file from one location to another.
     */
    private void moveFile() {
        System.out.print("Enter source file path: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination file path: ");
        String destination = scanner.nextLine();
        try {
            fileOps.moveFile(source, destination);
        } catch (Exception e) {
            LoggerUtility.logError("Error moving file: " + e.getMessage());
        }
    }

    /**
     * Deletes a specified file.
     */
    private void deleteFile() {
        System.out.print("Enter file path: ");
        String path = scanner.nextLine();
        try {
            fileOps.deleteFile(path);
        } catch (Exception e) {
            LoggerUtility.logError("Error deleting file: " + e.getMessage());
        }
    }

    /**
     * Creates a new directory at the specified location.
     */
    private void createDirectory() {
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        dirOps.createDirectory(path);
    }

    /**
     * Deletes a specified directory.
     */
    private void deleteDirectory() {
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        dirOps.deleteDirectory(path);
    }

    /**
     * Searches for files within a specified directory based on a search term.
     */
    private void searchFiles() {
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter search term (file name or extension): ");
        String searchTerm = scanner.nextLine();
        List<String> foundFiles = searchOps.searchFiles(directoryPath, searchTerm);
        System.out.println("Found files:");
        for (String filePath : foundFiles) {
            System.out.println(filePath);
        }
    }

    /**
     * Exits the application.
     */
    private void exitApplication() {
        System.out.println("Exiting application...");
    }
}
