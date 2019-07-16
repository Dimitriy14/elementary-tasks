package com.softserveinc.tasks.numbers;

public class Main {
    public static void main(String[] args){
        try {
            System.out.println(Numbers.convertOneThousand(Integer.parseInt(args[0])));
        }   catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println("Incorrect argument");
        }
    }
}
