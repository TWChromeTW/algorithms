package structures.exceptions;

public class ListException extends Exception {
    public ListException(String message) {
        super("ERROR: " + message);
    }
}
