package nl.hu.sie.bep.friendspammer;


public class MessagingRuntimeException extends Exception {
    public MessagingRuntimeException(String message) {
        super(message);
    }

    public MessagingRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
