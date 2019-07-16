package com.softserveinc.tasks.envelopes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                System.out.print("Enter a: ");
                float a = scanner.nextFloat();

                System.out.print("Enter b: ");
                float b = scanner.nextFloat();

                Envelope firstEnvelope = new Envelope(a, b);

                System.out.print("Enter c: ");
                float c = scanner.nextFloat();

                System.out.print("Enter d: ");
                float d = scanner.nextFloat();

                Envelope secondEnvelope = new Envelope(c, d);

                if (firstEnvelope.canInsert(secondEnvelope)) {
                    System.out.println("You can put second envelope into first");

                } else if (secondEnvelope.canInsert(firstEnvelope)) {
                    System.out.println("You can put first envelope into second");

                } else {
                    System.out.println("It`s not possible to put envelopes into each other");
                }

            } catch (IllegalArgumentException e) {
                System.out.printf("Invalid input: %s\n", e.getMessage());

            } catch (InputMismatchException e) {
                System.out.println("Params must be numbers");
            }
            scanner.nextLine();
            System.out.println("Would you like to continue? Type y/yes to continue ");

        } while (tryAgain(scanner.nextLine()));

        scanner.close();
    }

    private static boolean tryAgain(String answ) {
        return answ.equalsIgnoreCase("y") || answ.equalsIgnoreCase("yes");
    }
}