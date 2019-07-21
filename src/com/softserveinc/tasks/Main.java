package com.softserveinc.tasks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskRunner tr = new TaskRunner(new Scanner(System.in));
        tr.startMenu();
    }
}