package ru.getcourse.dmdev.homework.week1;

/**
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).

 * Протестировать функцию в main.
 */

public class Task1 {
    public static void main(String[] args) {
        for (int minutes = 0; minutes <= 59; minutes++) {
            definesQuarterOfHour(minutes);
        }
    }

    public static void definesQuarterOfHour(int minutes) {
        if (minutes <= 14) {
            System.out.println("Minute number " + minutes + " is the first quarter of an hour");
        } else if (minutes <= 29) {
            System.out.println("Minute number " + minutes + " is the second quarter of an hour");
        } else if (minutes <= 44) {
            System.out.println("Minute number " + minutes + " is the third quarter of an hour");
        } else {
            System.out.println("Minute number " + minutes + " is the fourth quarter of an hour");
        }
    }
}
