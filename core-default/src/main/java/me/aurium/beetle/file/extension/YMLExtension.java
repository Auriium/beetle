package me.aurium.beetle.file.extension;

import java.nio.file.Path;
import java.util.Optional;

public class YMLExtension implements Extension {

    public static String KEY = ".yml";
    private final Path path;

    public YMLExtension(Path path) {
        this.path = path;
    }

    @Override
    public Path pathPlease() {
        return path;
    }

    Optional<String> getStringEnding(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(fileName.lastIndexOf(".")));
    }


    public static YMLExtension ofPath(Path path) {
        return new YMLExtension(ExtensionUtils.fromPath(path,KEY));
    }

    public static YMLExtension ofString(String string) {
        return ofPath(Path.of(string));
    }

}
