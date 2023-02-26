package ru.getcourse.dmdev.homework.week4.polymorphism;

public class Meteorite extends Asteroid {

    private final double flightTime;

    public Meteorite(String name, double weight, double pointInUniverse, double radius, AsteroidType asteroidType, double speed, double flightTime) {
        super(name, weight, pointInUniverse, radius, asteroidType, speed);
        this.flightTime = flightTime;
    }

    @Override
    public double getImpulse() {
        return getWeight() * getSpeed() + getRadius() * flightTime;
    }

    public double getFlightTime() {
        return flightTime;
    }

    @Override
    public String toString() {
        return "Meteorite{" +
                "name='" + getName() + '\'' +
                ", speed=" + getSpeed() +
                ", asteroidType=" + getAsteroidType() +
                ", flightTime=" + flightTime +
                ", weight=" + getWeight() +
                ", pointInUniverse=" + getPointInUniverse() +
                ", radius=" + getRadius() +
                '}';
    }
}