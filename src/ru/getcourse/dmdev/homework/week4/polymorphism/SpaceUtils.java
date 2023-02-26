package ru.getcourse.dmdev.homework.week4.polymorphism;

public final class SpaceUtils {

    private SpaceUtils() {
    }

    public static double getGravityForce(SpaceBody spaceBody1, SpaceBody spaceBody2) {
        return Math.abs((spaceBody1.getPointInUniverse() - spaceBody2.getPointInUniverse())
                * (spaceBody1.getWeight()) * spaceBody2.getWeight());
    }

    public static boolean isStar(SpaceBody spaceBody) {
        return spaceBody instanceof Star;
    }
}