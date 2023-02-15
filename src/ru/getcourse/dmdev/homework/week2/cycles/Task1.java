package ru.getcourse.dmdev.homework.week2.cycles;

import java.util.Scanner;

/**
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число,
 * а возвращать количество четных цифр (вторая функция - нечетных).
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1 {
    public static void main(String[] args) {
        int value = getValue();
        System.out.println("Количество четных цифр: " + countsEvenNumbers(value));
        System.out.println("Количество нечетных цифр: " + countsOddNumbers(value));
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

    private static int checkNumber(int value){
        if (value == 0) {
            return 1;
        }
        if (value < 0) {
            value *= -1;
        }
        return value;
    }

    private static int countsEvenNumbers(int value) {
        value = checkNumber(value);
        int counterEven = 0;
        while (value > 0) {
            if (value % 2 == 0) {
                counterEven++;
            }
            value /= 10;
        }
        return counterEven;
    }

    private static int countsOddNumbers(int value) {
        value = checkNumber(value);
        int counterOdd = 0;
        while (value > 0) {
            if (value % 2 != 0) {
                counterOdd++;
            }
            value /= 10;
        }
        return counterOdd;
    }
}



