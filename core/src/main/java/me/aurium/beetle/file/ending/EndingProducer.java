package me.aurium.beetle.file.ending;

import java.io.File;
import java.nio.file.Path;

public interface EndingProducer{

    EndingWrapper ofString(String string);
    EndingWrapper ofPath(Path path, EndingType type);
    EndingWrapper ofFile(File file);

}
