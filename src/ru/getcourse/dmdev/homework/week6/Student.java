package ru.getcourse.dmdev.homework.week6;

import java.util.List;
import java.util.Objects;

public class Student {

    private String name;
    private String surname;
    private int course;
    private List<Integer> grades;

    public Student(String name, String surname, int course, List<Integer> grades) {
        this.name = name;
        this.surname = surname;
        this.course = course;
        this.grades = grades;
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public double getAvgGrade() {
        double sum = 0.0;
        for (Integer grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getCourse() {
        return course;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course, grades);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }

    public void setGrades(List<Integer> grades) {
        this.grades = grades;
    }
}