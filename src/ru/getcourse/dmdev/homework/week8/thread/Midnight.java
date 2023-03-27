package ru.getcourse.dmdev.homework.week8.thread;

import ru.getcourse.dmdev.homework.week8.util.VolatileParams;

public class Midnight extends Thread {

    private final Object lock = new Object();

    @Override
    public void run() {
        while (!VolatileParams.isWin) {
            synchronized (lock) {
                try {
                    System.out.println("--------------------Midnight--------------------");
                    lock.notifyAll();
                    lock.wait(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public Object getLock() {
        return lock;
    }
}
