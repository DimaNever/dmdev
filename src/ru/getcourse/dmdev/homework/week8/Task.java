package ru.getcourse.dmdev.homework.week8;

import ru.getcourse.dmdev.homework.week8.model.Crystal;
import ru.getcourse.dmdev.homework.week8.model.Mages;
import ru.getcourse.dmdev.homework.week8.thread.CreatingCrystals;
import ru.getcourse.dmdev.homework.week8.thread.Midnight;
import ru.getcourse.dmdev.homework.week8.thread.Rocket;
import ru.getcourse.dmdev.homework.week8.util.ThreadUtil;
import ru.getcourse.dmdev.homework.week8.util.VolatileParams;

import java.util.ArrayList;
import java.util.List;

/**
 * Существует две постоянно соревнующиеся расы: маги огня и маги воздуха.
 * Их задача - как можно быстрее набрать 500 красных и 500 белых кристаллов.
 * <p>
 * Кристаллы растут на другой планете с рандомной скоростью от 2 до 5 рандомных кристаллов в сутки
 * (может быть 1 красный и 2 белых, а может и вовсе все 4 кристалла красного цвета).
 * <p>
 * Маги огня и маги воздуха отправляют раз в сутки по ракете за добычей кристаллов.
 * Каждая ракета может погрузить на борт от 2 до 5 рандомных кристаллов.
 * Если кристаллов нет - ракета улетает пустой.
 * <p>
 * Написать программу, которая симулирует процесс заполнения кристаллов у магов огня и воздуха.
 * Для симуляции принять, что и кристаллы создаются, и ракеты прилетают в одно и то же время - полночь.
 * <p>
 * Соревнование заканчивается, когда какая-то раса соберет необходимые кристаллы.
 */
public class Task {

    public static void main(String[] args) throws InterruptedException {
        Midnight midnight = new Midnight();
        List<Crystal> crystals = new ArrayList<>();
        CreatingCrystals creatingCrystals = new CreatingCrystals(midnight, crystals);
        Rocket rocketOfFire = new Rocket(midnight, new Mages("Fire"), creatingCrystals.getPlanet());
        Rocket rocketOfAir = new Rocket(midnight, new Mages("Air"), creatingCrystals.getPlanet());

        ThreadUtil.startThreads(midnight, creatingCrystals, rocketOfFire, rocketOfAir);
        ThreadUtil.joinThreads(midnight, creatingCrystals, rocketOfFire, rocketOfAir);

        System.out.println("WIN: Mages of " + VolatileParams.WINNER);
    }
}
