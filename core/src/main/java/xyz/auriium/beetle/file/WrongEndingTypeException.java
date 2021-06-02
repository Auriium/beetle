package xyz.auriium.beetle.file;

public class WrongEndingTypeException extends RuntimeException{

    public WrongEndingTypeException(String given, String expected) {
        super("Given filetype ending " + given + " when expecting " + expected);
    }

    public WrongEndingTypeException(String expected) {
        super("Expecting filetype ending of " + expected);
    }

}
