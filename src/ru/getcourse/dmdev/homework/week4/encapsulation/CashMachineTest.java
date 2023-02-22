package ru.getcourse.dmdev.homework.week4.encapsulation;

/**
 * Создать класс, описывающий банкомат.
 * Банкомат задается тремя свойствами:
 * - количеством купюр номиналом 10, 20 и 50.
 * <p>
 * Создать конструктор с тремя параметрами - количеством купюр каждого номинала.
 * Сделать методы для добавления денег в банкомат.
 * Сделать метод, снимающий деньги: он принимает сумму денег, а возвращает булево значение - успешность выполнения операции.
 * <p>
 * При снятии денег метод должен распечатывать каким количеством купюр какого номинала выдаётся сумма.
 * Сначала банкомат будет пытаться рассчитаться 50, далее добавит недостающие 20, и только затем 10
 * (не нужно рассматривать более сложные варианты выдачи наличных, чтобы не усложнять алгоритм).
 */
public class CashMachineTest {
    public static void main(String[] args) {
        CashMachine cashMachine = new CashMachine(2, 2, 3);
        System.out.println(cashMachine);

        cashMachine.addFifty(8);
        cashMachine.addTwenty(3);
        cashMachine.addTwenty(5);
        cashMachine.addTen(10);

        System.out.println();
        System.out.println(cashMachine.isMoneyWithdrawn(685));
        System.out.println();
        System.out.println(cashMachine.isMoneyWithdrawn(880));
        System.out.println();
        System.out.println(cashMachine.isMoneyWithdrawn(680));
    }
}

