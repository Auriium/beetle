package me.aurium.beetle.file.ending;

import me.aurium.beetle.file.WrongEndingTypeException;
import me.aurium.beetle.file.extension.Extension;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

/**
 * Abstract producer
 *
 * Probably should clean this up it feels like aUtils shitcode
 */
public class CommonEndingProducer implements EndingProducer {

    private final String key;
    private final Attributes attributes;

    CommonEndingProducer(String key, Attributes attributes) {
        this.key = key;
        this.attributes = attributes;
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

    public static class Builder {
        private final String key;
        private final Set<Class<? extends Extension>> attributes;

        public Builder(String key) {
            this.key = key;
            this.attributes = new HashSet<>();
        }

        public Builder withAttributes(Collection<Class<? extends Extension>> iterable) {
            attributes.addAll(iterable);

            return this;
        }

        public Builder withAttribute(Class<? extends Extension> tribute) {
            this.attributes.add(tribute);

            return this;
        }

        public CommonEndingProducer build() {
            return new CommonEndingProducer(key,new Attributes(attributes));
        }


    }

}
