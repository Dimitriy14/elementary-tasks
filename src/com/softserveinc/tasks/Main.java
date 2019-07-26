package com.softserveinc.tasks;

import com.softserveinc.tasks.models.Shape.Shape;
import com.softserveinc.tasks.models.Shape.ShapeFabric;
import com.softserveinc.tasks.models.Shape.Triangle;
import com.softserveinc.tasks.models.chess.Board;
import com.softserveinc.tasks.models.envelopes.Envelope;
import com.softserveinc.tasks.services.EnvelopeInsertion;
import com.softserveinc.tasks.validator.Validator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Main {
    private static BufferedReader reader;

    public static void main(String[] args) {
        reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                System.out.println("Choose task which you would like to run\n" +
                        "1. Chessboard\n" +
                        "2. Envelopes\n" +
                        "3. Triangles\n" +
                        "4. Parser\n" +
                        "5. Sequences(fibonacci/square)\n" +
                        "6. Lucky tickets\n" +
                        "7. Numbers\n" +
                        "Enter number of task which you would like to run");

                switch (reader.readLine()) {
                    case "1":
                        runChessBoard();
                        break;
                    case "2":

                        break;
                    case "3":

                        break;
                    case "4":

                        break;
                    case "5":

                        break;
                    case "6":

                        break;
                    case "7":

                        break;
                    case "q":
                    case "Q":
                            System.out.println("Bye!");
                        return;
                    default:
                        System.out.println("Incorrect task number, try again");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Got IOException");
                e.printStackTrace();
            }
        }
    }


    private static void runChessBoard() throws IOException {
        do {
            int width = 0;
            int height = 0;

            System.out.println("Enter the sides of chessboard in format: <width> <height>");
            String input = reader.readLine();
            String[] args = input.split(" ");

            try {
                width = Integer.parseInt(args[0]);
                height = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid type");
                continue;
            }

            if (Validator.checkIfGreaterThanZero(width, height)) {
                Board board = new Board(height, width);
                System.out.printf(board.toString());
            }


        } while (tryAgain());
    }

    private static void runEnvelopes() throws IOException {
        do {
            try {
                System.out.println("Enter envelope`s sides");
                System.out.print("Enter a: ");
                double a = Double.parseDouble(reader.readLine());

                System.out.print("Enter b: ");
                double b = Double.parseDouble(reader.readLine());

                System.out.print("Enter c: ");
                double c = Double.parseDouble(reader.readLine());

                System.out.print("Enter d: ");
                double d = Double.parseDouble(reader.readLine());

                if (!Validator.checkIfGreaterThanZero(a, b, c, d)) {
                    System.out.println("Invalid envelope`s sides");
                    continue;
                }

                Envelope env1 = new Envelope(a, b);
                Envelope env2 = new Envelope(c, d);

                if (EnvelopeInsertion.canInsert(env1, env2)) {
                    System.out.println("You can put second envelope into first");

                } else if (EnvelopeInsertion.canInsert(env1, env2)) {
                    System.out.println("You can put first envelope into second");

                } else {
                    System.out.println("It`s not possible to put envelopes into each other");
                }

            } catch (NumberFormatException e) {
                System.out.println("Params must be numbers");
            }
        } while (tryAgain());
    }

    private  void runTriangles() throws IOException{
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

            }

        } while (tryAgain());

        shapes.sort(Comparator.comparing(Shape::getSquare).reversed());

        System.out.println("============= Triangles list: ===============");
        for (Shape triangle : shapes) {
            System.out.printf("[%s]: %.2f cm\n", triangle.getName(), triangle.getSquare());
        }
    }

    static boolean tryAgain() throws IOException {
        System.out.println("Would you like to try again? Press y/yes");
        String answ = reader.readLine();

        return answ.equalsIgnoreCase("y") ||
                answ.equalsIgnoreCase("yes");

    }
}