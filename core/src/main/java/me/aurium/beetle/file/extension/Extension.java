package me.aurium.beetle.file.extension;

import java.nio.file.Path;

public interface Extension {

    Path getSeveredPath();
    Path getCombinedPath(Path basePath);

}
