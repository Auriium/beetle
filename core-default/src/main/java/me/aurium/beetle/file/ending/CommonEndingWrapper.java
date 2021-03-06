package me.aurium.beetle.file.ending;

import me.aurium.beetle.file.ending.EndingWrapper;
import me.aurium.beetle.file.ending.EndingType;

import java.nio.file.Path;

//probably should separate this out into an "in between stage" as well so we can have producers writing simply to internals
public class CommonEndingWrapper implements EndingWrapper {

    private final Path internalPath;
    private final EndingType type;

    public CommonEndingWrapper(Path internalPath, EndingType type) {
        this.internalPath = internalPath;
        this.type = type;
    }

    public Path getFullDirectPath(Path path) {
        switch (type) {
            case DIRECT:
                return internalPath;
            case INDIRECT:
                return path.resolve(path);
            default:
                throw new RuntimeException("Somehow type was not direct nor indirect :thinking:");
        }
    }

}
