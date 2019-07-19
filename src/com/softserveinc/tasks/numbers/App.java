package com.softserveinc.tasks.numbers;

import com.softserveinc.tasks.numbers.Core.Numbers;

public class App {
    public static void main(String[] args){
        try {
            System.out.println(Numbers.convertOneThousand(Integer.parseInt("999")));
        }   catch (NumberFormatException | ArrayIndexOutOfBoundsException e){
            System.out.println("Incorrect argument");
        }
    }
}
