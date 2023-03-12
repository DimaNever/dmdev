package ru.getcourse.dmdev.homework.week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toMap;


/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * <p>
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * <p>
 * Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * <p>
 * Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * <p>
 * Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 * <p>
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */
public class Task {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Rulon", "Oboev", 1, List.of(4, 2, 5)),
                new Student("Ugon", "Harleev", 2, List.of(3, 2, 4, 5, 3)),
                new Student("Ishod", "Izgoev", 3, List.of(4, 4, 4, 5)),
                new Student("Podshum", "Priboev", 1, List.of(4, 5)),
                new Student("Signal", "Otboev", 2, List.of(2, 5)),
                new Student("Iznos", "Metallov", 2, List.of(4, 3, 5, 4)),
                new Student("Zalog", "Uspehov", 2, List.of(3, 5))
        );

        Map<Integer, List<Student>> mapStudents = students.stream()
                .filter(student -> student.getGrades().size() > 3)
                .collect(groupingBy(Student::getCourse));
        System.out.println(mapStudents);

        Map<Integer, Double> collect = students.stream()
                .filter(student -> student.getGrades().size() > 3)
                .collect(toMap(Student::getCourse, Student::getAvgGrade, (oldValue, newValue)-> newValue));
        System.out.println(collect);

        Map<Integer, List<String>> mapStudentsFullName = students.stream()
                .collect(groupingBy(Student::getCourse, mapping(Student::getFullName,Collectors.toList())));
        System.out.println(mapStudentsFullName);
    }
}
