package org.example;

/**
 * The entry point for the File Manager application.
 */
public class FileManager {
    /**
     * Main method to start the File Manager application.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}
