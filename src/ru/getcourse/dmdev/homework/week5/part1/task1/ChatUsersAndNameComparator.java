package ru.getcourse.dmdev.homework.week5.part1.task1;

import java.util.Comparator;

public class ChatUsersAndNameComparator implements Comparator<Chat> {

    @Override
    public int compare(Chat o1, Chat o2) {
        int i = Integer.compare(o2.getCountUsers(), o1.getCountUsers());
        if (i == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return i;
    }
}
