package ru.getcourse.dmdev.homework.week5.part2_2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Cinema2 {

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

    public List<Film> getFilmsOfYear(int year) {
        List<Film> films = new LinkedList<>();
        if (!filmLibrary.containsKey(year)) {
            System.out.println("There are no films for the given year");
            return films;
        } else {
            for (Map.Entry<Integer, Set<Film>> entry : filmLibrary.entrySet()) {
                if (year == entry.getKey()) {
                    Set<Film> filmSet = entry.getValue();
                    films.addAll(filmSet);
                }
            }
        }
        return films;
    }


    public List<Film> getFilmsOfYearAndMonth(int year, int month) {
        List<Film> films = new LinkedList<>();
        if (!filmLibrary.containsKey(year)) {
            System.out.println("No films for this year and month");
            return films;
        }

        for (Map.Entry<Integer, Set<Film>> entry : filmLibrary.entrySet()) {
            Set<Film> value = entry.getValue();
            for (Film film : value) {
                if (year == entry.getKey() && month == film.getMonth()) {
                    films.add(film);
                }
            }
        }

        if (films.isEmpty()) {
            System.out.println("No films for this year and month");
        }
        return films;
    }

    public List<Film> getFilmsOfGenre(String findGenre) {
        List<Film> films = new LinkedList<>();
        for (Map.Entry<Integer, Set<Film>> entry : filmLibrary.entrySet()) {
            Set<Film> value = entry.getValue();
            for (Film film : value) {
                if (findGenre.equals(film.getGenre())) {
                    films.add(film);
                }
            }
        }
        if (films.isEmpty()) {
            System.out.println("This genre is not in the cinema");
        }
        return films;
    }

    public List<Film> topList() {
        Set<Film> films = new TreeSet<>(Comparator.comparing(Film::getRating).reversed());
        for (Map.Entry<Integer, Set<Film>> entry : filmLibrary.entrySet()) {
            Set<Film> value = entry.getValue();
            films.addAll(value);
        }

        List<Film> topList = new ArrayList<>(10);
            for (Film film : films) {
                while (topList.size() < 10) {
                topList.add(film);
                break;
            }
        }
        return topList;
    }

    @Override
    public String toString() {
        return "Cinema2{" +
                "filmLibrary=" + filmLibrary +
                '}';
    }
}
