package ru.getcourse.dmdev.homework.week5.part2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Cinema {

    private Map<Integer, Set<Film>> filmLibrary = new TreeMap<>();

    public void addNewFilm(Film film) {

        if (!(filmLibrary.containsKey(film.getYear()))) {
            Set<Film> filmList = new LinkedHashSet<>();
            filmList.add(film);
            filmLibrary.put(film.getYear(), filmList);
        } else {
            for (Map.Entry<Integer, Set<Film>> entry : filmLibrary.entrySet()) {
                Set<Film> value = entry.getValue();
                for (Film filmVal : value) {
                    if (filmVal.getId() == film.getId()) {
                        System.out.println("The film is already in the cinema");
                        return;
                    } else if (entry.getKey() == film.getYear()) {
                        Set<Film> filmList = entry.getValue();
                        filmList.add(film);
                        filmLibrary.put(film.getYear(), filmList);
                    }
                }
            }
        }
    }

    public void getFilmsOfYear(int year) {
        if (!filmLibrary.containsKey(year)) {
            System.out.println("There are no films for the given year");
            return;
        }

        for (Map.Entry<Integer, Set<Film>> entry : filmLibrary.entrySet()) {
            if (year == entry.getKey()) {
                System.out.println(entry);
            }
        }
    }

    public void getFilmsOfYearAndMonth(int year, int month) {
        if (!filmLibrary.containsKey(year)) {
            System.out.println("No films for this year and month");
            return;
        }

        int count = 0;
        for (Map.Entry<Integer, Set<Film>> entry : filmLibrary.entrySet()) {
            Set<Film> value = entry.getValue();
            for (Film film : value) {
                if (year == entry.getKey() && month == film.getMonth()) {
                    count++;
                    System.out.println(entry);
                }
            }
        }

        if (count == 0) {
            System.out.println("No films for this year and month");
        }
    }

    public void getFilmsOfGenre(String findGenre) {
        int count = 0;
        for (Map.Entry<Integer, Set<Film>> entry : filmLibrary.entrySet()) {
            Set<Film> value = entry.getValue();
            for (Film film : value) {
                if (findGenre.equals(film.getGenre())) {
                    count++;
                    System.out.println(film);
                }
            }
        }
        if (count == 0) {
            System.out.println("This genre is not in the cinema");
        }
    }

    public List<Film> topList() {
        List<Film> films = new ArrayList<>();
        for (Map.Entry<Integer, Set<Film>> entry : filmLibrary.entrySet()) {
            Set<Film> value = entry.getValue();
            films.addAll(value);
        }
        films.sort(Comparator.comparing(Film::getRating).reversed());
        return films;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "filmLibrary=" + filmLibrary +
                '}';
    }
}
