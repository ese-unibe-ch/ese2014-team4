package ch.unibe.ese2014.team4.controller.exceptions;

public class InactiveUserException extends RuntimeException {

    public InactiveUserException(String s) {
        super(s);
    }
}
