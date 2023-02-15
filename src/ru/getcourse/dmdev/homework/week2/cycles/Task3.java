package ru.getcourse.dmdev.homework.week2.cycles;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился в IT компанию на позицию
 * Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера, чтобы инвестировать в акции с доходностью 2% в месяц.
 * <p>
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 * <p>
 * Для интереса: попробовать увеличить процент, которые Ваня инвестирует из своей зарплаты
 */

public class Task3 {
    public static void main(String[] args) {

        double salary = 600;
        int timeWork = 38;
        final double PERCENTAGE_OF_SALARY = 0.1;
        final double PERCENTAGE_OF_INVESTMANT = 0.02;
        final double EXPENSES = 300;

        double moneyBroker10 = countInvestments(salary, timeWork, PERCENTAGE_OF_SALARY, PERCENTAGE_OF_INVESTMANT);
        double moneyAccount10 = countSaving(salary, timeWork, EXPENSES, PERCENTAGE_OF_SALARY);
        double moneyBroker20 = countInvestments(salary, timeWork, 0.2, PERCENTAGE_OF_INVESTMANT);
        double moneyAccount20 = countSaving(salary, timeWork, EXPENSES, 0.2);

        System.out.println("Расчёт при ежемесячном инвестировании 10% от ЗП");
        System.out.printf("Средства накопленные на брокерском счёте: $" + "%.2f", moneyBroker10);
        System.out.printf("\nСредства накопленные на счёте Ивана: $" + "%.2f", moneyAccount10);
        System.out.printf("\nОбщая сумма денежных средств: $" + "%.2f", (moneyBroker10 + moneyAccount10));
        System.out.println("\n");
        System.out.println("Расчёт при ежемесячном инвестировании 20% от ЗП");
        System.out.printf("Средства накопленные на брокерском счёте: $" + "%.2f", moneyBroker20);
        System.out.printf("\nСредства накопленные на счёте Ивана: $" + "%.2f", moneyAccount20);
        System.out.printf("\nОбщая сумма денежных средств: $" + "%.2f", (moneyBroker20 + moneyAccount20));
    }

    private static double countInvestments(double salary, int timeWork, double PERCENTAGE_OF_SALARY, double PERCENTAGE_OF_INVESTMANT) {
        double moneyForInvestment;
        double moneyInBrokerAccount = 0;
        for (int i = 1; i <= timeWork; i++) {
            moneyForInvestment = salary * PERCENTAGE_OF_SALARY;
            moneyInBrokerAccount += moneyInBrokerAccount * PERCENTAGE_OF_INVESTMANT + moneyForInvestment;
            if (i % 6 == 0) {
                salary += 400;
            }
        }
        return moneyInBrokerAccount;
    }

    private static double countSaving(double salary, int timeWork, double EXPENSES, double PERCENTAGE_OF_SALARY) {
        double moneyInSavingsAccount = 0;
        for (int i = 1; i <= timeWork; i++) {
            moneyInSavingsAccount += salary - EXPENSES - salary * PERCENTAGE_OF_SALARY;
            if (i % 6 == 0) {
                salary += 400;
            }
        }
        return moneyInSavingsAccount;
    }
}
