package com.softserveinc.tasks.fibonacci;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("You need to enter 2 int args");
            return;
        }

        try {
            printFibonacci(Integer.parseInt(args[0]),
                    Integer.parseInt(args[1]));
        } catch (NumberFormatException e) {
            System.out.println("Arguments must be integers");
        }
    }


    private static void printFibonacci(int a, int b) {
        int current = 0;
        int next = 1;

        while (next <= b) {
            int tmp = current + next;
            current = next;
            next = tmp;

            if (current >= a && current <= b) {
                System.out.println(current);
            }
        }
    }
}
