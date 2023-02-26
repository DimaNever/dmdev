package ru.getcourse.dmdev.homework.week4.polymorphism;

public class Comet extends SpaceBody implements WithImpulse, Crashable {

    private final double tailLength;

    public Comet(String name, double weight, double pointInUniverse, double radius, double tailLength) {
        super(name, weight, pointInUniverse, radius);
        this.tailLength = tailLength;
    }

    @Override
    public boolean isCrash(SpaceBody spaceBody) {
        return Math.abs(this.getPointInUniverse() - spaceBody.getPointInUniverse()) < 1500
                && SpaceUtils.getGravityForce(this, spaceBody) > 5.5E10;
    }

    @Override
    public double getElectromagnetic() {
        return (getWeight() + getRadius()) * tailLength;
    }

    @Override
    public double getImpulse() {
        return getWeight() * 2;
    }

    @Override
    public double getDiameter() {
        return getRadius() + tailLength / 5;
    }

    @Override
    public String toString() {
        return "Comet{" +
                "name='" + getName() + '\'' +
                ", tailLength=" + tailLength +
                ", electromagnetic=" + getElectromagnetic() +
                ", impulse=" + getImpulse() +
                ", diameter=" + getDiameter() +
                ", weight=" + getWeight() +
                ", pointInUniverse=" + getPointInUniverse() +
                ", radius=" + getRadius() +
                '}';
    }
}