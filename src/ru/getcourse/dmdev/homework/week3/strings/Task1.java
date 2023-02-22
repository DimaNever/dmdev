package ru.getcourse.dmdev.homework.week3.strings;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом.
 * Также удалить пробелы.
 * Результат привести к верхнему регистру.

 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */
public class Task1 {
    private static final String EMPTY = "";
    private static final String SPACE = " ";

    public static void main(String[] args) {
        String srt = "abc Cpddd Dio OsfWw";
        formatToUpperCaseWithoutSpaceAndDuplicates(srt);
    }

    private static void formatToUpperCaseWithoutSpaceAndDuplicates(String srt) {
        char[] chars = srt.replace(SPACE, EMPTY).toUpperCase().toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                chars[i] = ' ';
            }
        }
        String result = new String(chars).replace(SPACE, EMPTY);
        System.out.println(result);
    }
}