package structures.exceptions;

public class TreeException extends Exception {
    public TreeException(String message) {
        super("ERROR: " + message);
    }
}
