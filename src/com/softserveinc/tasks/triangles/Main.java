package com.softserveinc.tasks.triangles;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String inputFormat = "Enter your triangle in format <name>, <first side>, <second side>, <third side>\n";

    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.print(inputFormat);

                String input = scanner.nextLine();

                String[] arguments = input.replaceAll("\\s+", "").split(",");

                triangles.add(new Triangle(arguments[0], Double.parseDouble(arguments[1]), Double.parseDouble(arguments[2]), Double.parseDouble(arguments[3])));

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Incorrect input format");

            } catch (NotValidTriangleException e) {
                System.out.println(e.getMessage());
            }

            System.out.print("Would you like to continue? Type y/yes to continue ");

        } while (tryAgain(scanner.nextLine()));

        triangles.sort(Comparator.comparing(Triangle::getSquare).reversed());

        System.out.println("============= Triangles list: ===============");
        for (Triangle triangle : triangles) {
            System.out.printf("[%s]: %.2f cm\n", triangle.getName(), triangle.getSquare());
        }

        scanner.close();
    }

    private static boolean tryAgain(String answ) {
        return answ.equalsIgnoreCase("y") || answ.equalsIgnoreCase("yes");
    }
}
