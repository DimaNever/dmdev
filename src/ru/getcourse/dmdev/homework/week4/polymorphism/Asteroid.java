package ru.getcourse.dmdev.homework.week4.polymorphism;

public class Asteroid extends SpaceBody implements WithImpulse, Crashable {

    private final double speed;
    private final AsteroidType asteroidType;

    public Asteroid(String name, double weight, double pointInUniverse, double radius, AsteroidType asteroidType, double speed) {
        super(name, weight, pointInUniverse, radius);
        this.asteroidType = asteroidType;
        this.speed = speed;
    }

    public double getDistance(int time) {
        return speed * time;
    }

    @Override
    public double getElectromagnetic() {
        return Math.pow(getWeight() * getRadius() - speed / getWeight(), 3);
    }

    @Override
    public double getImpulse() {
        return getWeight() * speed;
    }

    @Override
    public boolean isCrash(SpaceBody spaceBody) {
        return Math.abs(this.getPointInUniverse() - spaceBody.getPointInUniverse()) < 1500
                && SpaceUtils.getGravityForce(this, spaceBody) > 5.5E10;
    }

    public double getSpeed() {
        return speed;
    }

    public AsteroidType getAsteroidType() {
        return asteroidType;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "name='" + getName() + '\'' +
                ", asteroidType=" + asteroidType +
                ", speed=" + speed +
                ", weight=" + getWeight() +
                ", pointInUniverse=" + getPointInUniverse() +
                ", radius=" + getRadius() +
                '}';
    }
}