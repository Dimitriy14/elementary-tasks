package com.softserveinc.tasks.triangles;

public class Triangle {
    private String name;
    private double a;
    private double b;
    private double c;
    private double square;


    /**
     * create an envelope
     *
     * @param name  - name of triangle
     * @param a,b,c - sides of triangle
     * @throws IllegalArgumentException is thrown in case if params are lower than 0
     */
    public Triangle(String name, double a, double b, double c) throws NotValidTriangleException {
        if (a <= 0 || b <= 0 || c <= 0) {
            throw new NotValidTriangleException("sides should be greater than 0");
        }

        if (a + b <= c || a + c <= b || c + b <= a) {
            throw new NotValidTriangleException(
                    "it`s not possible to create a triangle with sides: " +
                            a + "," + b + "," + c);
        }

        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.square = this.calcSquare();
    }


    /**
     * calculate half perimeter of triangle
     */
    private double calcHalfPerimeter() {
        return (this.a + this.b + this.c) / 2;
    }

    /**
     * calculate square of triangle
     */
    private double calcSquare() {
        double hp = this.calcHalfPerimeter();
        return Math.sqrt(hp * (hp - this.a) * (hp - this.b) * (hp - this.c));
    }

    public String getName() {
        return this.name;
    }

    public double getSquare() {
        return this.square;
    }
}
