package com.softserveinc.tasks.numbers;

import java.util.HashMap;
import java.util.Map;

public class Numbers {
    public static Map<Integer, String> numNames = new HashMap<>();

    public static Map<Integer, String> tensNames = new HashMap<>();

    static {
        numNames.put(0, "");
        numNames.put(1, " one");
        numNames.put(2, " two");
        numNames.put(3, " three");
        numNames.put(4, " four");
        numNames.put(5, " five");
        numNames.put(6, " six");
        numNames.put(7, " seven");
        numNames.put(8, " eight");
        numNames.put(9, " nine");
        numNames.put(10, " ten");
        numNames.put(11, " eleven");
        numNames.put(12, " twelve");
        numNames.put(13, " thirteen");
        numNames.put(14, " fourteen");
        numNames.put(15, " fifteen");
        numNames.put(16, " sixteen");
        numNames.put(17, " seventeen");
        numNames.put(18, " eighteen");
        numNames.put(19, " nineteen");

        tensNames.put(1, " ten");
        tensNames.put(2, " twenty");
        tensNames.put(3, " thirty");
        tensNames.put(4, " forty");
        tensNames.put(5, " fifty");
        tensNames.put(6, " sixty");
        tensNames.put(7, " seventy");
        tensNames.put(8, " eighty");
        tensNames.put(9, " ninety");
    }

    public static String convertOneThousand(int number) {
        String soFar;

        if (number == 0) return "zero";

        if (number % 100 < 20){
            soFar = numNames.get(number%100);
            number /= 100;
        }
        else {
            soFar = numNames.get(number % 10);
            number /= 10;

            soFar = tensNames.get(number % 10) + soFar;
            number /= 10;
        }
        if (number == 0) return soFar;
        return numNames.get(number) + " hundred" + soFar;
    }
}
