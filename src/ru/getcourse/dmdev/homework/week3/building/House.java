package ru.getcourse.dmdev.homework.week3.building;

public class House {
    private int number;
    private Floor[] floors;

    public House(int number, Floor[] floors) {
        this.number = number;
        this.floors = floors;
    }

    public Floor[] getFloors() {
        return floors;
    }

    void print() {
        System.out.println("Number of house: " + number + ", quantity floors: " + floors.length + ".");
    }
}