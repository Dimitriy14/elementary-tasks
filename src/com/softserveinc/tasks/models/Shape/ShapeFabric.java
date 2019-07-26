package com.softserveinc.tasks.models.Shape;

import com.softserveinc.tasks.validator.Validator;

public class ShapeFabric {
    public static Shape CreateShape(String[] args) {
        Shape shape = null;
        if (args.length == 4) {
            double side1 = Double.parseDouble(args[1]);
            double side2 = Double.parseDouble(args[2]);
            double side3 = Double.parseDouble(args[3]);


            if (isValidTriangle(side1, side2, side3) &&
                    Validator.checkIfGreaterThanZero(side1, side2, side3)) {
                shape = new Triangle(args[0], side1, side2, side3);
            }

        } else {
            throw new InvalidShapeException();
        }
        return shape;
    }

    private static boolean isValidTriangle(double side1, double side2, double side3) {
        return side1 + side2 > side3 && side1 + side3 > side2 &&
                side2 + side3 > side1;
    }
}
