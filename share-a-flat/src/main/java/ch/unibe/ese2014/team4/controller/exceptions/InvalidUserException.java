package ch.unibe.ese2014.team4.controller.exceptions;

public class InvalidUserException extends RuntimeException {

    public InvalidUserException(String s) {
        super(s);
    }
}
