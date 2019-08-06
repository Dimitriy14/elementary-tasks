package com.softserveinc.tasks.view;

import com.softserveinc.tasks.services.NumberToWord;

import java.io.BufferedReader;
import java.io.IOException;

public class RunNumbers implements TaskRunner {
    private BufferedReader reader;

    public RunNumbers(BufferedReader reader){
        this.reader = reader;
    }

    @Override
    public void run() {
        do {
            System.out.println("Enter number in range from 0 to 999: ");
            try {
                int num = Integer.parseInt(reader.readLine());
                System.out.println(NumberToWord.convertOneThousand(num));
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            } catch (IOException e){
                System.out.printf("Incorrect input: %s", e.toString());
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
