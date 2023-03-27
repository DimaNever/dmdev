package ru.getcourse.dmdev.homework.week8.util;

public final class VolatileParams {

    public volatile static boolean isWin = false;
    public volatile static String WINNER;

    private VolatileParams() {
    }

    public static void setIsWin(boolean isWin) {
        VolatileParams.isWin = isWin;
    }

    public static void setWINNER(String WINNER) {
        VolatileParams.WINNER = WINNER;
    }
}

