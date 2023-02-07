package ru.getcourse.dmdev.homework.week2.cycles;

import java.util.Scanner;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * <p>
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */

public class Task2 {
    public static void main(String[] args) {
        int number = getValue();
        System.out.println(numberReversal(number));
        System.out.println(numberReversal2(number)); //сначала сделал так)
    }

    private static int getValue() {
        System.out.println("Введите целое число.");
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Вы ввели не целое число. \nПожалуйста повторите ввод.");
            sc = new Scanner(System.in);
        }
        return sc.nextInt();
    }

    private static int numberReversal(int value) {
        int value1 = value;
        int revers = 0;
        int counter = -1;
        while (value != 0) {
            counter++;
            value /= 10;
        }
        for (int i = counter; i >= 0; i--) {

            revers += (int) (Math.pow(10, i) * (value1 % 10));
            value1 /= 10;
        }
        return revers;
    }

    private static int numberReversal2(int value) {
        if (value < 0) {
            value *= -1;
            return Integer.parseInt(new StringBuilder(value + "").reverse().toString())* -1;
        }
        return Integer.parseInt(new StringBuilder(value + "").reverse().toString());
    }
}
