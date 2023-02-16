package ru.getcourse.dmdev.homework.week3.building;

public class Apartment {
    private int numberOfApartment;
    private Room[] rooms;

    public Apartment(int numberOfApartment, Room[] rooms) {
        this.numberOfApartment = numberOfApartment;
        this.rooms = rooms;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void print() {
        System.out.println("Number of apartment: " + numberOfApartment + ", quantity rooms: " + rooms.length + ".");
    }
}
