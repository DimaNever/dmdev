package ru.getcourse.dmdev.homework.week2.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа
 * (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]

 * Далее определить среднее арифметическое всех элементов целочисленного массива и
 * вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class Task2 {
    public static void main(String[] args) {
        char[] symbols = {'a', '6', 'y', 'P', 'T', 'q', '9', '+' };
        System.out.println(Arrays.toString(symbols));
        System.out.println(Arrays.toString(convertCharToInt(symbols)));
        printNewArrayAboveAverage(symbols);
    }

    private static int[] convertCharToInt(char[] originalArray) {
        int[] numbers = new int[originalArray.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = originalArray[i];    //можно было закастить numbers[i] = (int)originalArray[i]
        }
        return numbers;
    }

    private static void printNewArrayAboveAverage(char[] originalArray) {
        int[] values = convertCharToInt(originalArray);
        double average;
        double sum = 0;
        for (int i : values) {
            sum += i;
        }
        average = sum / values.length;
        for (int value : values) {
            if (value > average) {
                System.out.print(value + " ");
            }
        }
    }
}
