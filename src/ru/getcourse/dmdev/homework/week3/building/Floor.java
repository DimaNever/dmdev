package ru.getcourse.dmdev.homework.week3.building;

public class Floor {
    private int number;
    private Apartment[] apartments;

    public Floor(int number, Apartment[] apartments) {
        this.number = number;
        this.apartments = apartments;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void print() {
        System.out.println("Number of floor: " + number + ", quantity apartments: " + apartments.length + ".");
    }
}