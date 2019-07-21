package com.softserveinc.tasks;

import com.softserveinc.tasks.envelopes.Envelope;
import com.softserveinc.tasks.task1.Fields;
import com.softserveinc.tasks.task1.chess.Board;
import com.softserveinc.tasks.triangles.NotValidTriangleException;
import com.softserveinc.tasks.triangles.Triangle;
import com.softserveinc.tasks.validator.Validator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaskRunner {
    Scanner scanner;

    TaskRunner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void startMenu() {
        while (true) {
            System.out.println("Choose task which you would like to run\n" +
                    "1. Chessboard\n" +
                    "2. Envelopes\n" +
                    "3. Triangles\n" +
                    "4. Parser\n" +
                    "5. Sequences(fibonacci/square)\n" +
                    "6. Lucky tickets\n" +
                    "7. Numbers\n" +
                    "Enter number of task which you would like to run");

            String task = scanner.nextLine();

            switch (task) {
                case "1":
                    runChessBoard();
                    break;
                case "2":
                    runEnvelopes();
                    break;
                case "3":
                    runTriangles();
                    break;
                default:
                    scanner.close();
                    return;
            }
        }
    }

    private void runChessBoard() {
        do {
            int width = 0;
            int height = 0;
            System.out.println("Enter the sides of chessboard in format: <width> <height>");
            String input = scanner.nextLine();
            String[] args = input.split(" ");

            if (args.length != 2) {
                System.out.println("Incorrect input");
                continue;
            }

            try {
                width = Integer.parseInt(args[0]);
                height = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid type");
                continue;
            }


            if (!Validator.checkIfGreaterThanZero(width, height)) {
                System.out.println("Incorrect arguments");
                continue;
            }

            Fields field = new Board(width, height);

            System.out.println(field.create());

        } while (tryAgain());
    }

    private void runEnvelopes() {
        do {
            try {
                System.out.println("Enter envelope`s sides");
                System.out.print("Enter a: ");
                double a = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter b: ");
                double b = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter c: ");
                double c = Double.parseDouble(scanner.nextLine());

                System.out.print("Enter d: ");
                double d = Double.parseDouble(scanner.nextLine());

                if (!Validator.checkIfGreaterThanZero(a, b, c, d)) {
                    System.out.println("Invalid envelope`s sides");
                    continue;
                }

                Envelope firstEnvelope = new Envelope(a, b);
                Envelope secondEnvelope = new Envelope(c, d);

                if (firstEnvelope.canInsert(secondEnvelope)) {
                    System.out.println("You can put second envelope into first");

                } else if (secondEnvelope.canInsert(firstEnvelope)) {
                    System.out.println("You can put first envelope into second");

                } else {
                    System.out.println("It`s not possible to put envelopes into each other");
                }

            } catch (NumberFormatException e) {
                System.out.println("Params must be numbers");
            }
        } while (tryAgain());
    }

    private  void runTriangles(){
        List<Triangle> triangles = new ArrayList<>();

        do {
            try {
                System.out.print("Enter your triangle in format <name>, <first side>, <second side>, <third side>\n");

                String input = scanner.nextLine();

                String[] arguments = input.replaceAll("\\s+", "").split(",");
                double a = Double.parseDouble(arguments[1]);
                double b = Double.parseDouble(arguments[2]);
                double c =  Double.parseDouble(arguments[3]);

                if(!Validator.isValidTriangle(a,b,c)){
                    System.out.println("Invalid triangle");
                    continue;
                }

                triangles.add(new Triangle(arguments[0],a,b,c));

            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                System.out.println("Incorrect input format");

            }

        } while (tryAgain());

        triangles.sort(Comparator.comparing(Triangle::getSquare).reversed());

        System.out.println("============= Triangles list: ===============");
        for (Triangle triangle : triangles) {
            System.out.printf("[%s]: %.2f cm\n", triangle.getName(), triangle.getSquare());
        }
    }

    boolean tryAgain() {
        System.out.println("Would you like to try again? Press y/yes");
        String answ = scanner.nextLine();

        return answ.equalsIgnoreCase("y") ||
                answ.equalsIgnoreCase("yes");

    }
}
