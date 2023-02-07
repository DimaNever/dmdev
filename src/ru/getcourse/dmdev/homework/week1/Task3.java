package ru.getcourse.dmdev.homework.week1;

/**
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.

 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */

public class Task3 {
    public static void main(String[] args) {

        double areaFirstTriangle = calculatesAreaTriangle(4,60);
        double areaSecondTriangle = calculatesAreaTriangle(60, 4);
        comparesArea(areaFirstTriangle, areaSecondTriangle);
    }

    public static double calculatesAreaTriangle(int a, int b){
        return a * b / 2.0;
    }

    public static void comparesArea(double areaFirstTriangle, double areaSecondTriangle){
        if (areaFirstTriangle > areaSecondTriangle){
            System.out.println("The first triangle is larger than the second");
        } else if (areaFirstTriangle < areaSecondTriangle) {
            System.out.println("The first triangle is smaller than the second");
        } else {
            System.out.println("Triangles are equal");
        }
    }
}
