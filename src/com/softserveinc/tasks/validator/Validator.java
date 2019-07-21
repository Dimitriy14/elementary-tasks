package com.softserveinc.tasks.validator;

public class Validator {
    public static boolean checkIfGreaterThanZero(double... numbers) {
        for (double number : numbers) {
            if (number <= 0) return false;
        }
        return true;
    }

    public static boolean isValidTriangle(double a, double b, double c){
        if(!Validator.checkIfGreaterThanZero(a,b,c)) return false;

        return !(a + b <= c) && !(a + c <= b) && !(c + b <= a);
    }
}
