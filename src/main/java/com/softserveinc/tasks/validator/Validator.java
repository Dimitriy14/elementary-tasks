package com.softserveinc.tasks.validator;

public interface Validator {
    static boolean checkIfGreaterThanZero(double... numbers) {
        for (double number : numbers) {
            if (number <= 0) return false;
        }
        return true;
    }
    boolean isValid();
}
