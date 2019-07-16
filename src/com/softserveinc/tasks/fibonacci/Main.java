package com.softserveinc.tasks.fibonacci;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("Invalid arguments");
            return;
        }

        String[] scope = args[0].split(",");

        int fib = 0;

        try {
            for (int i = 0; fib < Integer.parseInt(scope[1]); i++) {
                fib = fibonacci(i);
                if (fib >= Integer.parseInt(scope[0])) {
                    System.out.println(fib);
                }
            }

        } catch (NumberFormatException e){
            System.out.println("Incorrect input. Arguments must be integers");
        }
    }

    private static int fibonacci(int n){
        if (n <= 1){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
