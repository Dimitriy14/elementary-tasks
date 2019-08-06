package com.softserveinc.tasks.models.shape;

public class InvalidShapeException extends RuntimeException {
    public InvalidShapeException() {
        super("Invalid shape!");
    }
}
