package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to handle searching for files within a directory based on file name or extension.
 */
public class SearchOperations {

    /**
     * Searches for files within the specified directory that match the search term.
     *
     * @param directoryPath The path of the directory to search within.
     * @param searchTerm The term to search for in file names.
     * @return A list of file paths that match the search term.
     */
    public List<String> searchFiles(String directoryPath, String searchTerm) {
        List<String> foundFiles = new ArrayList<>();
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            searchRecursively(directory, searchTerm, foundFiles);
        } else {
            LoggerUtility.logError("Directory not found: " + directoryPath);
        }
        return foundFiles;
    }

    /**
     * Recursively searches for files within a directory and its subdirectories.
     *
     * @param directory The directory to search within.
     * @param searchTerm The term to search for in file names.
     * @param foundFiles A list to store the found file paths.
     */
    private void searchRecursively(File directory, String searchTerm, List<String> foundFiles) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    searchRecursively(file, searchTerm, foundFiles);
                } else if (file.getName().contains(searchTerm)) {
                    foundFiles.add(file.getAbsolutePath());
                }
            }
        }
    }
}
