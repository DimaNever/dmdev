package ru.getcourse.dmdev.homework.week8.util;

import java.util.Random;

public final class RandomUtil {

    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static int getNextFromTwoToFive(int minBound, int maxBound) {
        return RANDOM.nextInt((maxBound - minBound) + 1) + minBound;
    }

    public static int getNext(int bound) {
        return RANDOM.nextInt(bound);
    }
}
