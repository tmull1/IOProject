package org.example;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class to handle directory operations such as listing contents,
 * creating directories, and deleting directories.
 */
public class DirectoryOperations {

    /**
     * Lists the contents of the specified directory, including file names,
     * sizes, and last modified dates. If the directory is empty, it indicates
     * that the directory is empty.
     *
     * @param directoryPath The path of the directory to list.
     */
    public void listDirectoryContents(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null && files.length > 0) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                for (File file : files) {
                    System.out.println(String.format("%-20s %-10d %s",
                            file.getName(),
                            file.length(),
                            sdf.format(new Date(file.lastModified()))));
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            LoggerUtility.logError("Directory not found: " + directoryPath);
        }
    }

    /**
     * Creates a new directory at the specified path.
     *
     * @param directoryPath The path of the directory to be created.
     */
    public void createDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.mkdirs()) {
            LoggerUtility.logInfo("Created directory: " + directoryPath);
        } else {
            LoggerUtility.logError("Failed to create directory: " + directoryPath);
        }
    }

    /**
     * Deletes the specified directory and its contents.
     *
     * @param directoryPath The path of the directory to be deleted.
     */
    public void deleteDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists() && directory.isDirectory()) {
            deleteRecursively(directory);
            LoggerUtility.logInfo("Deleted directory: " + directoryPath);
        } else {
            LoggerUtility.logError("Directory not found: " + directoryPath);
        }
    }

    /**
     * Recursively deletes a directory and all its contents.
     *
     * @param file The directory or file to be deleted.
     */
    private void deleteRecursively(File file) {
        File[] allContents = file.listFiles();
        if (allContents != null) {
            for (File content : allContents) {
                deleteRecursively(content);
            }
        }
        file.delete();
    }
}

