package ru.getcourse.dmdev.homework.week4.polymorphism;

public class Planet extends SpaceBody {

    private final boolean water;
    private final int temperature;

    public Planet(String name, double weight, double pointInUniverse, double radius, boolean water, int temperature) {
        super(name, weight, pointInUniverse, radius);
        this.water = water;
        this.temperature = temperature;
    }

    public boolean isAlive() {
        System.out.print(getName() + " is alive: ");
        return water && (-80 < temperature && temperature < 150);
    }

    @Override
    public double getElectromagnetic() {
        return Math.pow(getWeight() * getRadius(), 2);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + getName() + '\'' +
                ", water=" + water +
                ", weight=" + getWeight() +
                ", pointInUniverse=" + getPointInUniverse() +
                ", radius=" + getRadius() +
                '}';
    }
}