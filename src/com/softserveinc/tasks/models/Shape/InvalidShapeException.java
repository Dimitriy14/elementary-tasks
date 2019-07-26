package com.softserveinc.tasks.models.Shape;

public class InvalidShapeException extends RuntimeException {
    public InvalidShapeException() {
        super("Invalid shape!");
    }
}
