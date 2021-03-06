package me.aurium.beetle.file.ending;

import me.aurium.beetle.file.extension.Extension;

public class WrongAttributeException extends RuntimeException {

    WrongAttributeException(Extension attribute) {
        super("Ending activated while missing attribute " + attribute.getClass().getCanonicalName());
    }

}
