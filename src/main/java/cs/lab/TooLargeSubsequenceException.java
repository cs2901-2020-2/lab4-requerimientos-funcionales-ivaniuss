package cs.lab;

public class TooLargeSubsequenceException extends Exception{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    TooLargeSubsequenceException(String message) {
        super(message);
    }
}
