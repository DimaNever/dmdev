package ru.getcourse.dmdev.homework.week5.part1.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * <p>
 * Задача:
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству пользователей,
 * а если это количество совпадает, то по названию в алфавитном порядке.
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */
public class ChatDemo {

    public static void main(String[] args) {
        List<Chat> chatList = new ArrayList<>();
        chatList.add(new Chat("abc", 850));
        chatList.add(new Chat("xyz", 2400));
        chatList.add(new Chat("gh", 9500));
        chatList.add(new Chat("def", 555));
        chatList.add(new Chat("bbc", 2400));
        chatList.add(new Chat("kl", 1800));

        System.out.println(chatList);
        ChatUtil.removeIfLessThanThousand(chatList);
        System.out.println(chatList);

        Collections.sort(chatList);
        System.out.println(chatList);

        chatList.sort(new ChatUsersAndNameComparator());
        System.out.println(chatList);

        //или просто так)
        chatList.sort(Comparator.comparing(Chat::getCountUsers).reversed().thenComparing(Chat::getName));
        System.out.println(chatList);
    }
}
