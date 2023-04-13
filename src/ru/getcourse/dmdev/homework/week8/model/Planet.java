package ru.getcourse.dmdev.homework.week8.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Planet {

    private final Object lock = new Object();
    private final List<Crystal> planet = new LinkedList<>();

    public Planet() {
    }

    public Planet(List<Crystal> crystalList) {
        planet.addAll(crystalList);
    }

    public void add(Crystal robotDetail) {
        planet.add(robotDetail);
    }

    public Crystal remove(int index) {
        return planet.remove(index);
    }

    public List<Crystal> removeAll() {
        List<Crystal> crystals = new ArrayList<>(planet);
        planet.clear();
        return crystals;
    }

    public int size() {
        return planet.size();
    }

    public boolean isNotEmpty() {
        return !planet.isEmpty();
    }

    public Object getLock() {
        return lock;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "planet=" + planet +
                '}';
    }
}
