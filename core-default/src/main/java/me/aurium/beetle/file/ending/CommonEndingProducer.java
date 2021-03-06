package me.aurium.beetle.file.ending;

import me.aurium.beetle.file.WrongEndingTypeException;

import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

/**
 * Abstract producer
 *
 * Probably should clean this up it feels like aUtils shitcode
 */
public class CommonEndingProducer implements EndingProducer {

    private final String key;

    public CommonEndingProducer(String key) {
        this.key = key;
    }

    Optional<String> getStringEnding(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(fileName.lastIndexOf(".")));
    }



    Path fromPath(Path name) {
        String internal = name.toString();
        String endingString = getStringEnding(internal).orElse("NONEXISTENT");

        if (endingString.equals("NONEXISTENT")) {
            internal += endingString;
        } else if (!endingString.equals(key)) {
            throw new WrongEndingTypeException(endingString,key);
        }

        return Path.of(internal);
    }


    public EndingWrapper ofString(String name) {
        return new CommonEndingWrapper(fromPath(Path.of(name)), EndingType.INDIRECT);
    }

    public EndingWrapper ofPath(Path path, EndingType type) {
        return new CommonEndingWrapper(fromPath(path),type);
    }

    public EndingWrapper ofFile(File file) {
        return new CommonEndingWrapper(fromPath(file.toPath()),EndingType.INDIRECT);
    }

}
