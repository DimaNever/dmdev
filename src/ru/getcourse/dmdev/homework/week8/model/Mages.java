package ru.getcourse.dmdev.homework.week8.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Mages {

    private final String name;
    private final Map<Crystal, Integer> crystals = new EnumMap<>(Crystal.class);

    public Mages(String name) {
        this.name = name;
    }

    public void addCrystals(List<Crystal> crystalList) {
        crystalList.forEach(crystal -> crystals.merge(crystal, 1, Integer::sum));
    }

    public boolean isWinner() {
        if (crystals.get(Crystal.WHITE) != null && crystals.get(Crystal.RED) != null) {
            return (crystals.get(Crystal.WHITE) >= 500 && crystals.get(Crystal.RED) >= 500);
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

    public void countCrystals() {
        System.out.println("***********************************************\n" +
                "Mages of " + name + " collected:\n" +
                "White crystals = " + crystals.get(Crystal.WHITE) + " and Red crystals = " + crystals.get(Crystal.RED) +
                "\n***********************************************");
    }
}
