package ru.getcourse.dmdev.homework.week3.building;

/**
 * Представить в виде классов и их композиции следующую модель.
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * - Каждая комната содержит поле проходная она или нет (boolean).
 * В каждом классе реализовать метод print, который на консоль выводит информацию об объекте
 * (должны присутствовать все поля объекта!).

 * Например, метод print класса этаж должен выводить на консоль:
 * “Этаж 2, количество квартир 18”
 * Создание всех объектов вынести в отдельный класс с методом main.
 * Там же реализовать метод printAllInformation, который на вход принимает объект типа дом,
 * и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.
 */
public class HouseTest {
    public static void main(String[] args) {
        Room room1 = new Room(true);
        Room room2 = new Room(false);
        Room room3 = new Room(true);

        Room[] rooms1 = {room1, room2, room3};
        Room[] rooms2 = {room1, room3};
        Room[] rooms3 = {room1, room3, room2};

        Apartment apartment1 = new Apartment(1, rooms1);
        Apartment apartment2 = new Apartment(2, rooms2);
        Apartment apartment3 = new Apartment(3, rooms3);

        apartment1.print();

        Apartment[] apartments1 = {apartment1, apartment2, apartment3};
        Apartment[] apartments2 = {apartment1, apartment2, apartment1, apartment1, apartment2, apartment3};
        Apartment[] apartments3 = {apartment1, apartment3};

        Floor floor1 = new Floor(1, apartments1);
        Floor floor4 = new Floor(2, apartments2);
        Floor floor9 = new Floor(3, apartments3);

        floor1.print();

        Floor[] floors = {floor1, floor4, floor9};

        House house = new House(12, floors);
        house.print();
        System.out.println("**************************************************************");
        printAllInformation(house);
    }

    private static void printAllInformation(House house) {
        house.print();
        for (Floor floor : house.getFloors()) {
            floor.print();
            for (Apartment apartment : floor.getApartments()) {
                apartment.print();
                for (Room room : apartment.getRooms()) {
                    room.print();
                }
            }
        }
    }
}