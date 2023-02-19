package ru.getcourse.dmdev.homework.week3.strings;

import java.util.Arrays;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * Написать 2 метода:
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * <p>
 * Посчитать сумму всех чисел из строки
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class Task2 {
    public static void main(String[] args) {
        String str = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";

        int[] ints = getArrayOfInts(str);
        System.out.println(Arrays.toString(ints));

        int sum = getSum(ints);
        System.out.println(sum);
    }

    private static int getSum(int[] ints) {
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
        }
        return sum;
    }

    private static int[] getArrayOfInts(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (char aChar : chars) {
            switch (aChar) {
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> count++;
            }
        }

        int[] ints = new int[count];
        int counter = 0;
        for (char aChar : chars) {
            switch (aChar) {
                case '0' -> ints[counter++] = 0;
                case '1' -> ints[counter++] = 1;
                case '2' -> ints[counter++] = 2;
                case '3' -> ints[counter++] = 3;
                case '4' -> ints[counter++] = 4;
                case '5' -> ints[counter++] = 5;
                case '6' -> ints[counter++] = 6;
                case '7' -> ints[counter++] = 7;
                case '8' -> ints[counter++] = 8;
                case '9' -> ints[counter++] = 9;
            }
        }
        return ints;
    }
}







