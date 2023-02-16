package ru.getcourse.dmdev.homework.week3.building;

public class Floor {
    private int numberOfFloor;
    private Apartment[] apartments;

    public Floor(int numberOfFloor, Apartment[] apartments) {
        this.numberOfFloor = numberOfFloor;
        this.apartments = apartments;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    void print() {
        System.out.println("Number of floor: " + numberOfFloor + ", quantity apartments: " + apartments.length + ".");
    }
}

