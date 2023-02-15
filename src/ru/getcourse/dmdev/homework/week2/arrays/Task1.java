package ru.getcourse.dmdev.homework.week2.arrays;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы
 * (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]

 * Не забывать, что всю логику приложения нужно выносить в отдельные функции.
 * main - только для тестирования написанного функционала.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] values = {3, 5, -6, 3, 2, -9, 0, -123};
        System.out.println(Arrays.toString(makeArrayWithoutNegativeNumbers(values)));
    }

    private static int countIndexOfNewArray(int[] originalArray) {
        int currentIndex = 0;
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] >= 0) {
                currentIndex++;
            }
        }
        return currentIndex;
    }

    private static int[] makeArrayWithoutNegativeNumbers(int[] originalArray) {
        int[] result = new int[countIndexOfNewArray(originalArray)];
        for (int currentIndex = 0, i = 0; currentIndex < result.length; i++) {
            if (originalArray[i] >= 0) {
                result[currentIndex] = originalArray[i] * result.length;
                currentIndex++;
            }
        }
        return result;
    }
}
