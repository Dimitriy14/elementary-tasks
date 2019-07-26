package com.softserveinc.tasks.models.sequence;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid argument");
            return;
        }

        try {
            int n = Integer.parseInt(args[0]);

            if (n < 0) {
                System.out.println("Number can`t be lower than 0");
                return;
            }

            printSeq(n);

        } catch (NumberFormatException e) {
            System.out.println("It`s not a number!");
            e.printStackTrace();
        }
    }

    static void printSeq(int n) {
        for (int i = 0; Math.pow(i, 2) <= n; i++) {
            System.out.println(i);
        }
    }
}
