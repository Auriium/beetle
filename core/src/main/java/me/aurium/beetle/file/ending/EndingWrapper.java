package me.aurium.beetle.file.ending;

import java.nio.file.Path;

//idk a file or something please help
public interface EndingWrapper {

    /**
     * Returns this plus base path (the full path)
     * @return the entire full path to this object
     */
    Path getFullDirectPath(Path basePath);


}
