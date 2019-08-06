package com.softserveinc.tasks.view;

import com.softserveinc.tasks.models.shape.Shape;
import com.softserveinc.tasks.models.shape.ShapeFabric;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunTriangles implements TaskRunner {
    private BufferedReader reader;

    public RunTriangles(BufferedReader reader){
        this.reader = reader;
    }

    @Override
    public void run() {
        List<Shape> shapes = new ArrayList<>();

        do {
            try {
                System.out.print("Enter your triangle in format <name>, <first side>, <second side>, <third side>\n");

                String input = reader.readLine();

                String[] arguments = input.replaceAll("\\s+", "").split(",");

                Shape shape = ShapeFabric.CreateShape(arguments);

                shapes.add(shape);

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Incorrect input format");
            } catch (IOException e){
                System.out.printf("Incorrect input: %s", e.toString());
            }

        } while (tryAgain());

        shapes.sort(Comparator.comparing(Shape::getSquare).reversed());

        System.out.println("============= Triangles list: ===============");
        for (Shape triangle : shapes) {
            System.out.printf("[%s]: %.2f cm\n", triangle.getName(), triangle.getSquare());
        }
    }

    private boolean tryAgain() {
        String answ = "";
        System.out.println("Would you like to add more triangles? Press y/yes");
        try {
            answ = reader.readLine();
        }
        catch (IOException e){
            System.out.printf("Incorrect input: %s", e.toString());
        }
        return answ.equalsIgnoreCase("y") ||
                answ.equalsIgnoreCase("yes");

    }
}
