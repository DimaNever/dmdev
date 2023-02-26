package ru.getcourse.dmdev.homework.week4.polymorphism;

public abstract class SpaceBody {

    private final String name;
    private final double weight;
    private final double pointInUniverse;
    private final double radius;

    public SpaceBody(String name, double weight, double pointInUniverse, double radius) {
        this.name = name;
        this.weight = weight;
        this.pointInUniverse = pointInUniverse;
        this.radius = radius;
    }

    public abstract double getElectromagnetic();

    public double getDiameter() {
        System.out.print("Diameter " + name + ": ");
        return getRadius() * 2;
    }

    public void weightCompare(SpaceBody spaceBody) {
        if (this.weight > spaceBody.weight) {
            System.out.println("Космическое тело " + this.name + " тяжелее, чем " + spaceBody.name);
        } else if (this.weight < spaceBody.weight) {
            System.out.println("Космическое тело " + this.name + " легче, чем " + spaceBody.name);
        } else {
            System.out.println("Космические тела имеют одинаковый вес");
        }
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getPointInUniverse() {
        return pointInUniverse;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "SpaceBody{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", pointInUniverse=" + pointInUniverse +
                ", radius=" + radius +
                '}';
    }
}