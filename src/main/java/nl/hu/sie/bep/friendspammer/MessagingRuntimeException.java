package nl.hu.sie.bep.friendspammer;

import javax.mail.MessagingException;

public class MessagingRuntimeException extends Exception {
    public MessagingRuntimeException(String message) {
        super(message);
    }
    public MessagingRuntimeException(String message, Throwable throwable) {
        super(message, throwable);
    }

}
