package com.softserveinc.tasks.view;

import com.softserveinc.tasks.models.sequence.Sequence;
import com.softserveinc.tasks.models.sequence.Squares;

import java.io.BufferedReader;
import java.io.IOException;

public class RunSquareSeq implements TaskRunner {
    BufferedReader reader;

    public RunSquareSeq(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        do {
            System.out.println("Enter a limit number of sequence: ");

            int num = 0;
            try {
                num = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("It`s not a number!");
                e.printStackTrace();
            } catch (IOException e) {
                System.out.printf("Incorrect input: %s", e.toString());
            }


            if (num < 0) {
                System.out.println("Number can`t be lower than 0");
                continue;
            }

            Sequence s = new Squares(num);
            System.out.printf("Result: %s\n", s.toString());

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
