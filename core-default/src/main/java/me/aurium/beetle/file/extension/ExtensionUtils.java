package me.aurium.beetle.file.extension;

import me.aurium.beetle.file.WrongEndingTypeException;

import java.nio.file.Path;
import java.util.Optional;

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
