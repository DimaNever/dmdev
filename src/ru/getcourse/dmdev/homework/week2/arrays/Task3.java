package ru.getcourse.dmdev.homework.week2.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.

 * Пример:
 *                                [-4, -18]
 * [-4, 0, 1, 9, 0, -18, 3] ->    [0, 0]
 *                                [1, 9, 3]
 */
public class Task3 {
    public static void main(String[] args) {
        int[] array = {-4, 0, 1, 9, 0, -18, 3};
        int[][] arraySeparator = arraySeparate(array);
        for (int[] ints : arraySeparator) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static int[][] arraySeparate(int[] values) {
        int counterNegative = 0;
        int counterZero = 0;
        int counterPositive = 0;
        for (int value : values) {
            if (value < 0) {
                counterNegative++;
            } else if (value == 0) {
                counterZero++;
            } else {
                counterPositive++;
            }
        }
        int[][] arraySeparator = new int[3][];
        arraySeparator[0] = new int[counterNegative];
        arraySeparator[1] = new int[counterZero];
        arraySeparator[2] = new int[counterPositive];
        int negativeIndex = 0;
        int zeroIndex = 0;
        int positiveIndex = 0;
        for (int i = 0; i < values.length; i++) {                       //здесь ИДЕЯ советует iter, но мне кажется что лучше fori.
            if (values[i] < 0) {
                arraySeparator[0][negativeIndex++] = values[i];
            } else if (values[i] == 0) {
                arraySeparator[1][zeroIndex++] = values[i];
            } else {
                arraySeparator[2][positiveIndex++] = values[i];
            }
        }
        return arraySeparator;
    }
}
