package ru.getcourse.dmdev.homework.week8.thread;

import ru.getcourse.dmdev.homework.week8.model.Crystal;
import ru.getcourse.dmdev.homework.week8.model.Mages;
import ru.getcourse.dmdev.homework.week8.model.Planet;
import ru.getcourse.dmdev.homework.week8.util.RandomUtil;
import ru.getcourse.dmdev.homework.week8.util.VolatileParams;

import java.util.ArrayList;
import java.util.List;

import static ru.getcourse.dmdev.homework.week8.util.CrystalConst.MAX_CRYSTALS_COUNT;
import static ru.getcourse.dmdev.homework.week8.util.CrystalConst.MIN_CRYSTALS_COUNT;

public class Rocket extends Thread {

    private final Midnight midnight;
    private final Mages mages;
    private final Planet planet;

    public Rocket(Midnight midnight, Mages mages, Planet planet) {
        this.midnight = midnight;
        this.mages = mages;
        this.planet = planet;
    }

    @Override
    public void run() {
        try {
            while (!mages.isWinner()) {
                List<Crystal> gatheredCrystals = gatherCrystalsFromPlanet();
                mages.addCrystals(gatheredCrystals);
                waitNextMidnight();
                if (mages.isWinner() || VolatileParams.isWin) {
                    if (mages.isWinner()) {
                        VolatileParams.setWINNER(mages.getName());
                    }
                    VolatileParams.setIsWin(true);
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mages.countCrystals();
    }

    private List<Crystal> gatherCrystalsFromPlanet() {
        int crystalsCount = RandomUtil.getNextFromTwoToFive(MIN_CRYSTALS_COUNT, MAX_CRYSTALS_COUNT);
        List<Crystal> gatheredCrystalsFromPlanet = new ArrayList<>(MAX_CRYSTALS_COUNT);
        synchronized (planet.getLock()) {
            if (planet.size() < crystalsCount && planet.size() >= MIN_CRYSTALS_COUNT) {
                gatheredCrystalsFromPlanet.addAll(planet.removeAll());
            } else if (planet.isNotEmpty() && planet.size() >= MIN_CRYSTALS_COUNT) {
                for (int i = 0; i < crystalsCount; i++) {
                    Crystal removeCrystal = planet.remove(RandomUtil.getNext(planet.size()));
                    gatheredCrystalsFromPlanet.add(removeCrystal);
                }
            }
            System.out.println("Rocket of Mages " + mages.getName() + " can pick up crystals: " + crystalsCount);
            System.out.printf("Rocket %s gathered crystals total: %s\n", mages.getName(), gatheredCrystalsFromPlanet.size());
            System.out.println("Total crystals on Planet: " + planet.size());
        }
        return gatheredCrystalsFromPlanet;
    }

    private void waitNextMidnight() throws InterruptedException {
        synchronized (midnight.getLock()) {
            midnight.getLock().wait();
        }
    }

    public Mages getMages() {
        return mages;
    }
}