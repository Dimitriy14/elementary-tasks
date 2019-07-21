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
     */
    public Triangle(String name, double a, double b, double c){
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
