package com.nayema;

public class Car {
    int currentSpeed;

    public void accelerate() {
        currentSpeed = currentSpeed + 5;
    }

    public void brake() {
        if(currentSpeed > 10) {
            currentSpeed = currentSpeed - 10;
        } else {
            currentSpeed = 0;
        }
    }
}
