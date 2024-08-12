package org.example;

import java.io.*;
import java.nio.file.*;

/**
 * Class to handle file operations such as copying, moving, and deleting files.
 */
public class FileOperations {

    /**
     * Copies a file from the source path to the destination path.
     *
     * @param source The source file path.
     * @param destination The destination file path.
     * @throws IOException If an I/O error occurs during the copy.
     */
    public void copyFile(String source, String destination) throws IOException {
        Path sourcePath = Paths.get(source);
        Path destinationPath = Paths.get(destination);
        Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        LoggerUtility.logInfo("Copied file from " + source + " to " + destination);
    }

    /**
     * Moves a file from the source path to the destination path.
     *
     * @param source The source file path.
     * @param destination The destination file path.
     * @throws IOException If an I/O error occurs during the move.
     */
    public void moveFile(String source, String destination) throws IOException {
        Path sourcePath = Paths.get(source);
        Path destinationPath = Paths.get(destination);
        Files.move(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);
        LoggerUtility.logInfo("Moved file from " + source + " to " + destination);
    }

    /**
     * Deletes the specified file.
     *
     * @param filePath The path of the file to be deleted.
     * @throws IOException If an I/O error occurs during deletion.
     */
    public void deleteFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.delete(path);
        LoggerUtility.logInfo("Deleted file: " + filePath);
    }
}
