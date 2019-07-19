package com.softserveinc.tasks.numbers.Core;

import java.util.HashMap;
import java.util.Map;

public class Numbers {
    public static Map<Integer, String> numNames = new HashMap<>();
    public static Map<Integer, String> tensNames = new HashMap<>();
    public static Map<Integer, String> hundredsNames = new HashMap<>();

    static {
        numNames.put(0, "");
        numNames.put(1, " один");
        numNames.put(2, " два");
        numNames.put(3, " три");
        numNames.put(4, " четыре");
        numNames.put(5, " пять");
        numNames.put(6, " шесть");
        numNames.put(7, " семь");
        numNames.put(8, " восемь");
        numNames.put(9, " девять");
        numNames.put(10, " десять");
        numNames.put(11, " одиннадцать");
        numNames.put(12, " двенадцать");
        numNames.put(13, " тринадцать");
        numNames.put(14, " четырнадцать");
        numNames.put(15, " пятнадцать");
        numNames.put(16, " шестнадцать");
        numNames.put(17, " семнадцать");
        numNames.put(18, " восемнадцать");
        numNames.put(19, " девятнадцать");

        tensNames.put(0, "");
        tensNames.put(1, " десять");
        tensNames.put(2, " двадцать");
        tensNames.put(3, " тридцать");
        tensNames.put(4, " сорок");
        tensNames.put(5, " пятьдесят");
        tensNames.put(6, " шестьдесят");
        tensNames.put(7, " семьдесят");
        tensNames.put(8, " восемьдесят");
        tensNames.put(9, " девяносто");

        hundredsNames.put(0, "");
        hundredsNames.put(1, "сто");
        hundredsNames.put(2, "двести");
        hundredsNames.put(3, "триста");
        hundredsNames.put(4, "четыреста");
        hundredsNames.put(5, "пятьсот");
        hundredsNames.put(6, "шестьсот");
        hundredsNames.put(7, "семьсот");
        hundredsNames.put(8, "восемьсот");
        hundredsNames.put(9, "девятьсот");
    }

    public static String convertOneThousand(int number) {
        String soFar;

        if (number == 0) return "ноль";

        if (number % 100 < 20) {
            soFar = numNames.get(number % 100);
            number /= 100;
        } else {
            soFar = numNames.get(number % 10);
            number /= 10;

            soFar = tensNames.get(number % 10) + soFar;
            number /= 10;
        }
        return hundredsNames.get(number) + soFar;
    }
}
