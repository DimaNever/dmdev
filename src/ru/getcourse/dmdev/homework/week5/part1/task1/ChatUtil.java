package ru.getcourse.dmdev.homework.week5.part1.task1;

import java.util.List;
import java.util.ListIterator;

public final class ChatUtil {

    private static final int TARGET_VALUE = 1000;

    private ChatUtil() {
    }

    public static void removeIfLessThanThousand(List<Chat> chats) {
        if (chats.isEmpty()){
            System.out.println("List is empty");
            return;
        }

        ListIterator<Chat> chatListIterator = chats.listIterator();
        while (chatListIterator.hasNext()) {
            Chat nextChat = chatListIterator.next();
            if (nextChat.getCountUsers() < TARGET_VALUE) {
                chatListIterator.remove();
            }
        }
//        chats.removeIf(nextChat -> nextChat.getCountUsers() < TARGET_VALUE);   // в одну строчку
    }
}
