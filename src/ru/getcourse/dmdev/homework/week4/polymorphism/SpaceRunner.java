package ru.getcourse.dmdev.homework.week4.polymorphism;

import static ru.getcourse.dmdev.homework.week4.polymorphism.AsteroidType.*;
import static ru.getcourse.dmdev.homework.week4.polymorphism.StarType.*;

/**
 * Создать иерархию классов, описывающих объекты в космосе.
 * Например, планета, спутник, звезда, астероид и т.д. У каждого есть набор методов и характеристик-свойств,
 * как общих (масса), так и присущих только этому типу космического объекта.
 * Необходимо учесть следующее:
 * В иерархии должно быть минимум 10 классов/интерфейсов
 * Обязательно использовать наследование (достаточно 1-2 уровней)
 * Использовать полиморфизм и продемонстрировать переопределение методов в иерархии
 * Продемонстрировать добавление собственных методов в классах-наследниках (можно с помощью интерфейсов)
 * При разработке иерархии держать в уме принцип инкапсуляции, выбирать корректные имена классов,
 * их полей и методов, пользоваться преимуществами полиморфизма
 * <p>
 * Отдавайте предпочтение интерфейсам, а не абстрактным классам
 * При переопределении методов обязательно использовать аннотацию @Override
 * Не создавать лишних классов в системе (полностью дублирующих или не содержащих назначения)
 * Каждый класс должен выполнять своё назначение
 * Для каждого не абстрактного класса переопределить метод toString() класса
 * для представления информации о классах в строковой форме
 * Создать общие методы:
 * - Рассчитывающие диаметр космического объекта
 * - Сравнивающий массы 2 космических объектов (метод не статический!)
 * <p>
 * Создать утилитный класс* SpaceUtils со следующими статическими методами:
 * - Принимающий 2 космический объекта и определяющий силу гравитации между ними (можно придумать любую формула на основании расстоянии между объектами и т.д.)
 * - Принимающий космический объект и определяющий, является ли он звездой или нет
 * <p>
 * Создать класс SpaceRunner, где протестировать написанный функционал
 * <p>
 * В этом задании нет одного правильного решения, подойдите к нему творчески.
 * <p>
 * Утилитный класс* - это такой класс, который:
 * - помечен ключевым словом final, чтобы запретить наследоваться от него
 * - имеет private конструктор, чтобы нельзя было создать объект этого класса
 * - имеет только статические методы и константы
 */
public class SpaceRunner {
    public static void main(String[] args) {

        Star starSun = new Star("Sun", 9000, 0, 1400, 120, YELLOW_GIANT);
        Star starAldebaran = new Star("Aldebaran", 1_000_000, 567.8, 8000, 360, RED_GIANT);
        System.out.println(starSun);
        System.out.println(starSun.getDiameter());
        System.out.println(starAldebaran);
        System.out.println(starAldebaran.getElectromagnetic());
        System.out.println(SpaceUtils.isStar(starSun));
        System.out.println();

        Asteroid asteroidVesta = new Asteroid("Vesta", 300.6, 1256.3, 100, CARBON, 800);
        System.out.println(asteroidVesta);
        System.out.println(SpaceUtils.getGravityForce(starSun, asteroidVesta));
        starSun.weightCompare(asteroidVesta);
        System.out.println(SpaceUtils.isStar(asteroidVesta));
        System.out.println();

        Meteorite meteoriteGoba = new Meteorite("Goba", 50.2, 10.8, 80, NICKEL_IRON, 200, 180);
        System.out.println(meteoriteGoba);
        System.out.println(meteoriteGoba.getImpulse());
        System.out.println();

        System.out.println(asteroidVesta.getDistance(100));
        System.out.println(meteoriteGoba.getDistance(50));
        System.out.println();

        SpaceBody comet = new Comet("Hartley2", 20, 548.65, 15, 150);
        System.out.println(comet);

        Planet planetEarth = new Planet("Earth", 420.5, 29, 500, true, 40);
        System.out.println(planetEarth);
        System.out.println(planetEarth.isAlive());

        System.out.println(asteroidVesta.isCrash(starAldebaran));
        System.out.println(meteoriteGoba.isCrash(planetEarth));


    }
}
