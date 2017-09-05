package com.nayema;

public class InvalidNumberException extends Exception {
    public String errorMessage;

    public InvalidNumberException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
