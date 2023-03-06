package ru.getcourse.dmdev.homework.week5.part1.task2;

import java.util.List;

public class Chat   {
    private String name;
    private List<User> userList;

    public Chat(String name, List<User> userList) {
        this.name = name;
        this.userList = userList;
    }

    public String getName() {
        return name;
    }

    public List<User> getUserList() {
        return userList;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", userList=" + userList +
                '}';
    }
}
