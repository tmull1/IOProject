package org.example;

import java.io.IOException;
import java.nio.file.*;
import java.util.logging.*;

/**
 * Utility class to handle logging of operations and exceptions.
 */
public class LoggerUtility {

    private static Logger logger = Logger.getLogger("FileManagerLogger");

    static {
        try {
            Files.createDirectories(Paths.get("logs"));
            FileHandler fileHandler = new FileHandler("logs/filemanager.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            System.err.println("Failed to initialize logger: " + e.getMessage());
        }
    }

    /**
     * Logs an informational message.
     *
     * @param message The message to log.
     */
    public static void logInfo(String message) {
        logger.info(message);
    }

    /**
     * Logs an error message.
     *
     * @param message The error message to log.
     */
    public static void logError(String message) {
        logger.severe(message);
    }
}
