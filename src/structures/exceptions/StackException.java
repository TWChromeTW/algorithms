package structures.exceptions;

public class StackException extends Exception {
    public StackException(String message) {
        super("ERROR: " + message);
    }
}
