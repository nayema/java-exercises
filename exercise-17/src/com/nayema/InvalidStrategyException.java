package com.nayema;

public class InvalidStrategyException extends Exception{
    public String errorMessage;

    public InvalidStrategyException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
