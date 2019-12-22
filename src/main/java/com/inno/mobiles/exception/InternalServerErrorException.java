package com.inno.mobiles.exception;

/**
 * @author Коваленко Александр
 */
public class InternalServerErrorException extends RuntimeException {

    public InternalServerErrorException(String message) {
        super(message);
    }


    public InternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }


    public InternalServerErrorException(Throwable cause) {
        super(cause);
    }
}
