package ru.getcourse.dmdev.homework.week3.building;

public class Room {
    private final boolean isPass;

    public Room(boolean isPass) {
        this.isPass = isPass;
    }

    public void print() {
        System.out.println("Pass room: " + isPass + ".");
    }
}