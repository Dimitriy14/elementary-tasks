package com.softserveinc.tasks;

import com.softserveinc.tasks.view.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Choose task which you would like to run\n" +
                    "1. Chessboard\n" +
                    "2. Envelopes\n" +
                    "3. Triangles\n" +
                    "4. Parser\n" +
                    "5. Numbers\n" +
                    "6. Lucky tickets\n" +
                    "7. Square sequence\n" +
                    "8. Fibonacci\n"+
                    "Enter number of task which you would like to run");
            TaskRunner runner  = null;

            try {
                switch (reader.readLine()) {
                    case "1":
                        runner = new RunChessBoard(reader);
                        break;
                    case "2":
                        runner = new RunEnvelope(reader);
                        break;
                    case "3":
                        runner = new RunTriangles(reader);
                        break;
                    case "4":
                        runner = new RunParser(reader);
                        break;
                    case "5":
                        runner = new RunNumbers(reader);
                        break;
                    case "6":

                        break;
                    case "7":
                        runner = new RunSquareSeq(reader);
                        break;
                    case "8":
                        runner = new RunFibonacci(reader);
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

            runner.run();
        }
    }
}