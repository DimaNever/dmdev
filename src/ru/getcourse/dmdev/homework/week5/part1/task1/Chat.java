package ru.getcourse.dmdev.homework.week5.part1.task1;

public class Chat implements Comparable<Chat> {
    private String name;
    private int countUsers;

    public Chat(String name, int countUsers) {
        this.name = name;
        this.countUsers = countUsers;
    }

    public String getName() {
        return name;
    }

    public int getCountUsers() {
        return countUsers;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", countUsers=" + countUsers +
                '}';
    }

    @Override
    public int compareTo(Chat o) {
        return getName().compareTo(o.getName());
    }
}
