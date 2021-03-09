package me.aurium.beetle.api.file.extension;

import java.nio.file.Path;

/**
 * Represents a specific filetype like .h2 or .sql or whatever
 *
 * Thanks to this being an interface localstorageextension are effectively decoupled from all implementations
 *  * even if standard practice would be to use prebuilt implementations from DBExtensions.
 */
public interface FileExtension {

    Path of(Path path);

}
