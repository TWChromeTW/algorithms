package structures.exceptions;

public class QueueException extends Exception {
    public QueueException(String message) {
        super("ERROR: " + message);
    }
}