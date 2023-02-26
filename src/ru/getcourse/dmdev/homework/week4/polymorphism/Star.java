package ru.getcourse.dmdev.homework.week4.polymorphism;

public class Star extends SpaceBody {

    private final int brightness;
    private final StarType starType;

    public Star(String name, double weight, double pointInUniverse, double radius, int brightness, StarType starType) {
        super(name, weight, pointInUniverse, radius);
        this.brightness = brightness;
        this.starType = starType;
    }

    @Override
    public double getElectromagnetic() {
        return Math.pow(getWeight() * getRadius(), 3);
    }

    public int getBrightness() {
        return brightness;
    }

    public StarType getStarType() {
        return starType;
    }

    @Override
    public String toString() {
        return "Star{" +
                "name='" + getName() + '\'' +
                ", brightness=" + brightness +
                ", starType=" + starType +
                ", weight=" + getWeight() +
                ", pointInUniverse=" + getPointInUniverse() +
                ", radius=" + getRadius() +
                '}';
    }
}