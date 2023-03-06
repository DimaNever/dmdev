package ru.getcourse.dmdev.homework.week5.part1.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public final class ChatUtil2 {

    private static final int TARGET_AGE = 18;

    private ChatUtil2() {
    }

    public static List<User> usersOlder18(List<Chat> chats) {
        if (chats.isEmpty()){
            System.out.println("List is empty");
            return null;
        }

        List<User> users = new ArrayList<>();
        for (Chat nextChat : chats) {
            List<User> users1 = nextChat.getUserList();
            for (User nextUser : users1) {
                if (nextUser.getAge() > TARGET_AGE) {
                    users.add(nextUser);
                }
            }
        }
        return users;
    }

    public static double averageAgeUsers(List<User> users) {
        if (users.isEmpty()){
            System.out.println("List is empty");
            return 0;
        }

        double sumAge = 0;
        for (User user : users) {
            sumAge += user.getAge();
        }
        return sumAge / users.size();
    }

    public static double averageAgeUsers2(List<User> users) {
        if (users.isEmpty()){
            System.out.println("List is empty");
            return 0;
        }

        double sumAge = 0;
        ListIterator<User> userListIterator = users.listIterator();
        while (userListIterator.hasNext()) {
            sumAge += userListIterator.next().getAge();
        }
        return sumAge / users.size();
    }
}
