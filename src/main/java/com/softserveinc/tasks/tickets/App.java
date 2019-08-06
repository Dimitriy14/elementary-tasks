package com.softserveinc.tasks.tickets;

import com.softserveinc.tasks.tickets.core.Tickets;

public class App {
    public static void main(String[] args) {
        if (args.length == 0 ){
            Tickets tickets = new Tickets();
            System.out.println("All range of tickets");
            System.out.printf("Moscow: %d\n", tickets.countLuckyForMoscow());
            System.out.printf("Petersburg: %d\n", tickets.countLuckyForPetersburg());
        } else if (args.length == 2) {
            Tickets tickets = new Tickets(Integer.getInteger(args[0]), Integer.getInteger(args[1]));
            System.out.printf("Tickets from %s to %s", args[0], args[1]);
            System.out.printf("Moscow: %d\n", tickets.countLuckyForMoscow());
            System.out.printf("Petersburg: %d\n", tickets.countLuckyForPetersburg());

        }
    }
}
