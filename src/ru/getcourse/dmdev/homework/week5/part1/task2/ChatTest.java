package ru.getcourse.dmdev.homework.week5.part1.task2;

import java.util.ArrayList;
import java.util.List;

/**
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей” будет список
 * объектов типа Пользователь, который имеет 3 поля: id (целочисленный идентификатор), имя и возраст.
 * Задача:
 * - Преобразовать список чатов в один список пользователей всех чатов, возраст которых больше 18 лет
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */
public class ChatTest {

    public static void main(String[] args) {
        List<User> userList1 = new ArrayList<>();
        userList1.add(new User(1, "Ivan", 16));
        userList1.add(new User(2, "Petr", 23));
        userList1.add(new User(3, "Sveta", 18));

        List<User> userList2 = new ArrayList<>();
        userList2.add(new User(4, "ALisa", 35));
        userList2.add(new User(5, "Maxim", 20));
        userList2.add(new User(6, "Pavel", 28));

        List<User> userList3 = new ArrayList<>();
        userList3.add(new User(7, "Sasha", 19));
        userList3.add(new User(8, "Olga", 15));
        userList3.add(new User(9, "Denis", 32));
        userList3.add(new User(10, "Anna", 17));

        List<Chat> chatList = new ArrayList<>();
        chatList.add(new Chat("Abc", userList1));
        chatList.add(new Chat("BBC", userList2));
        chatList.add(new Chat("NFT", userList3));

        System.out.println(chatList);
        List<User> oldUsers = ChatUtil2.usersOlder18(chatList);
        System.out.println(oldUsers);
        System.out.println(ChatUtil2.averageAgeUsers(oldUsers));
        System.out.println(ChatUtil2.averageAgeUsers2(oldUsers));
    }
}
