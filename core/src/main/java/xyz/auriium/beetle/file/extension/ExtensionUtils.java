package xyz.auriium.beetle.file.extension;

import xyz.auriium.beetle.file.WrongEndingTypeException;

import java.nio.file.Path;
import java.util.Optional;

/**
 * Extension utilities for the standard implementations. Probably can improve this in some way in the future
 */
public class ExtensionUtils {

    public static Optional<String> getStringEnding(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(fileName.lastIndexOf(".")));
    }

    public static Path fromPath(Path name, String key) {
        String internal = name.toString();
        String endingString = getStringEnding(internal).orElse("NONEXISTENT");

        if (endingString.equals("NONEXISTENT")) {
            internal += endingString;
        } else if (!endingString.equals(key)) {
            throw new WrongEndingTypeException(endingString,key);
        }

        return Path.of(internal);
    }

}
