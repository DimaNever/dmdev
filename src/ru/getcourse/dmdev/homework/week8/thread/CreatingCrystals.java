package ru.getcourse.dmdev.homework.week8.thread;

import ru.getcourse.dmdev.homework.week8.model.Crystal;
import ru.getcourse.dmdev.homework.week8.model.Planet;
import ru.getcourse.dmdev.homework.week8.util.RandomUtil;
import ru.getcourse.dmdev.homework.week8.util.VolatileParams;

import java.util.Collections;
import java.util.List;

import static ru.getcourse.dmdev.homework.week8.util.CrystalConst.MAX_CRYSTALS_COUNT;
import static ru.getcourse.dmdev.homework.week8.util.CrystalConst.MIN_CRYSTALS_COUNT;

public class CreatingCrystals extends Thread {

    private final Midnight midnight;
    private final Planet planet;

    public CreatingCrystals(Midnight midnight) {
        this(midnight, Collections.emptyList());
    }

    public CreatingCrystals(Midnight midnight, List<Crystal> crystalsInit) {
        this.planet = new Planet(crystalsInit);
        this.midnight = midnight;
    }

    @Override
    public void run() {
        try {
            while (!VolatileParams.isWin) {
                createNewCrystals();
                waitNextMidnight();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void createNewCrystals() {
        int countNewCrystals = RandomUtil.getNextFromTwoToFive(MIN_CRYSTALS_COUNT, MAX_CRYSTALS_COUNT);
        synchronized (planet.getLock()) {
            for (int i = 0; i < countNewCrystals; i++) {
                Crystal crystal = Crystal.CASHED_VALUES.get(RandomUtil.getNext(Crystal.CASHED_VALUES.size()));
                planet.add(crystal);
                System.out.println("Crystal created: " + crystal);
            }
            System.out.println("Create new crystals. Count: " + countNewCrystals);
            System.out.println("Number of crystals on Planet after creation: " + planet.size());
        }
    }

    private void waitNextMidnight() throws InterruptedException {
        synchronized (midnight.getLock()) {
            midnight.getLock().wait();
        }
    }

    public Planet getPlanet() {
        return planet;
    }
}
