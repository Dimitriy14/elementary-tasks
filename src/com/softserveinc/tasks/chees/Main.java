package com.softserveinc.tasks.chees;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter the height: ");
            int height = in.nextInt();

            System.out.print("Enter the width: ");
            int width = in.nextInt();

            Board chessBoard = new Board(height, width);
            chessBoard.print();

        } catch (IllegalArgumentException e) {
            System.out.printf("Invalid input: %s\n", e.getMessage());

        } catch (InputMismatchException e) {
            System.out.println("Params must be integers");
        }
    }
}