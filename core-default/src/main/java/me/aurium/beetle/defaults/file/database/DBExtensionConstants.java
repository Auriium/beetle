package me.aurium.beetle.defaults.file.database;

import me.aurium.beetle.defaults.datacore.LocalDB;
import me.aurium.beetle.defaults.datacore.LocalDBConstants;
import me.aurium.beetle.api.file.WrongEndingTypeException;

import java.nio.file.Path;
import java.util.Optional;

/**
 * Collection of default implementations of SourceableExtension
 */
public enum DBExtensionConstants implements SourceableFileExtension {

    H2(".db", LocalDBConstants.H2);

    private final String key;
    private final LocalDB dbType;

    DBExtensionConstants(String key, LocalDB dbType) {
        this.dbType = dbType;
        this.key = key;
    }

    @Override
    public Path of(Path path) {
        return fromPath(path,key);
    }

    @Override
    public LocalDB getType() {
        return dbType;
    }

    Optional<String> getStringEnding(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(fileName.lastIndexOf(".")));
    }

    Path fromPath(Path name, String key) {
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
