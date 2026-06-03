package com.linkshortner.Shortner.Exceptions;

public class LinkNotFound extends RuntimeException {
    public LinkNotFound(String message) {
        super(message);
    }
}
