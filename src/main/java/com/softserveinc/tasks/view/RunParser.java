package com.softserveinc.tasks.view;

import com.softserveinc.tasks.services.Parser;

import java.io.BufferedReader;
import java.io.IOException;

public class RunParser implements TaskRunner {
    BufferedReader reader;

    public RunParser(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        do {
            System.out.println("Enter params in format: " +
                    "<filepath, <row to count> or " +
                    "<filepath>, <row for changing>, <change row>");
            try {
                String input = reader.readLine();

                String[] args = input.replaceAll("\\s+","").split(",");

                if (args.length == 2) {
                    System.out.printf("Found rows: %d", Parser.countRows(args[0], args[1]));
                } else if (args.length == 3) {
                    Parser.replaceRows(args[0], args[1], args[2]);
                    System.out.println("Rows changed");
                } else{
                    System.out.println("Incorrect number of arguments");
                }
            } catch (IOException e) {
                System.out.printf("Incorrect input: %s", e.toString());
            } catch (Exception e){
                System.out.printf("Got an error: %s", e.toString());
            }

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
