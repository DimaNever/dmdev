package ru.getcourse.dmdev.homework.week3.building;

public class Apartment {
    private int number;
    private Room[] rooms;

    public Apartment(int number, Room[] rooms) {
        this.number = number;
        this.rooms = rooms;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public void print() {
        System.out.println("Number of apartment: " + number + ", quantity rooms: " + rooms.length + ".");
    }
}