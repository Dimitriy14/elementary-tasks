package com.softserveinc.tasks.tickets.core;

public class Tickets {
    public Tickets() {
    }

    int first = 100000;
    int last = 999999;

    public Tickets(int first, int last) {
        this.first = first;
        this.last = last;
    }

    public int countLuckyForPetersburg() {
        int counter = 0;

        for (int i = first; i <= last; i++) {
            if (isLuckyForPetersburg(i)) counter++;
        }

        return counter;
    }

    public int countLuckyForMoscow() {
        int counter = 0;

        for (int i = first; i <= last; i++) {
            if (isLuckyForMoscow(i)) counter++;
        }

        return counter;
    }

    public static boolean isLuckyForPetersburg(int n) {
        String num = Integer.toString(n);

        int odd = 0;
        int even = 0;

        for (char number : num.toCharArray()) {
            if (((int) number) % 2 == 0) {
                even += Character.getNumericValue(number);

            } else {
                odd += Character.getNumericValue(number);
            }
        }

        return even == odd;
    }

    public static boolean isLuckyForMoscow(int n) {
        String num = Integer.toString(n);

        int firstHalf = 0;
        int secondHalf = 0;

        for (char number: num.substring(0, 3).toCharArray()) {
            firstHalf += Character.getNumericValue(number);
        }

        for (char number: num.substring(3).toCharArray()) {
            secondHalf += Character.getNumericValue(number);
        }

        return firstHalf == secondHalf;
    }

}
