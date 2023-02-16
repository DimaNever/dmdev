package ru.getcourse.dmdev.homework.week3.building;

public class House {
    private int numberOfHouse;
    private Floor[] floors;

    public House(int numberOfHouse, Floor[] floors) {
        this.numberOfHouse = numberOfHouse;
        this.floors = floors;
    }

    public Floor[] getFloors() {
        return floors;
    }

    void print() {
        System.out.println("Number of house: " + numberOfHouse + ", quantity floors: " + floors.length + ".");
    }


}
