package com.softserveinc.tasks.view;

import com.softserveinc.tasks.models.sequence.Fibonacci;
import com.softserveinc.tasks.models.sequence.Sequence;

import java.io.BufferedReader;
import java.io.IOException;

public class RunFibonacci implements TaskRunner {
    BufferedReader reader;

    public RunFibonacci(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        do {
            System.out.println("Enter args in format " +
                    "<last number> or" +
                    "<first number>, <last number>");
            Sequence s = null;
            try {
                String input = reader.readLine();
                String[] args = input.replaceAll("\\s+", "").split(",");

                if (args.length == 1) {
                    s = new Fibonacci(Integer.parseInt(args[0]));
                } else if (args.length == 2) {
                    s = new Fibonacci(Integer.parseInt(args[0]),
                            Integer.parseInt(args[1]));
                } else {
                    System.out.println("Invalid number of arguments");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Arguments must be integers");
                continue;
            } catch (IOException e) {
                System.out.printf("Incorrect input: %s", e.toString());
                continue;
            }

            System.out.printf("Result: %s", s.toString());
        } while (tryAgain());

    }

    private boolean tryAgain() {
        String answ = "";
        System.out.println("\nWould you like to try again? Press y/yes");
        try {
            answ = reader.readLine();
        } catch (IOException e) {
            System.out.printf("Incorrect input: %s", e.toString());
        }
        return answ.equalsIgnoreCase("y") ||
                answ.equalsIgnoreCase("yes");
    }
}