package me.aurium.beetle.file.extension;

import java.nio.file.Path;
import java.util.Optional;

public class YMLExtension implements ConfigurableExtension {

    public static String KEY = ".yml";

    private final Path path;

    YMLExtension(Path path) {
        this.path = path;
    }

    @Override
    public Path pathPlease() {
        return path;
    }

    public static YMLExtension ofPath(Path path) {
        return new YMLExtension(ExtensionUtils.fromPath(path,KEY));
    }

    public static YMLExtension ofString(String string) {
        return ofPath(Path.of(string));
    }

}
