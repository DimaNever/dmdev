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

        double moneyBroker10 = countInvestments(salary, timeWork, EXPENSES, PERCENTAGE_OF_SALARY, PERCENTAGE_OF_INVESTMANT);
        double moneyAccount10 = countSaving(salary, timeWork, EXPENSES, PERCENTAGE_OF_SALARY);
        double moneyBroker20 = countInvestments(salary, timeWork, EXPENSES, 0.2, PERCENTAGE_OF_INVESTMANT);
        double moneyAccount20 = countSaving(salary, timeWork, EXPENSES, 0.2);

        System.out.println("Расчёт при ежемесячном инвестировании 10% от ЗП");
        System.out.println("Средства накопленные на брокерском счёте: $" + moneyBroker10);
        System.out.println("Средства накопленные на счёте Ивана: $" + moneyAccount10);
        System.out.println("Общая сумма денежных средств: $" + (moneyBroker10 + moneyAccount10));
        System.out.println();
        System.out.println("Расчёт при ежемесячном инвестировании 20% от ЗП");
        System.out.println("Средства накопленные на брокерском счёте: $" + moneyBroker20);
        System.out.println("Средства накопленные на счёте Ивана: $" + moneyAccount20);
        System.out.println("Общая сумма денежных средств: $" + (moneyBroker20 + moneyAccount20));
    }

    private static double countInvestments(double salary, int timeWork, double EXPENSES, double PERCENTAGE_OF_SALARY, double PERCENTAGE_OF_INVESTMANT) {
        double moneyForInvestment;
        double moneyInBrokerAccount = 0;
        for (int i = 1; i <= timeWork; i++) {
            moneyForInvestment = (salary - EXPENSES) * PERCENTAGE_OF_SALARY;
//            if (i == 1) {
//                moneyInBrokerAccount += moneyForInvestment;
//                continue;
//            }
            moneyInBrokerAccount += moneyInBrokerAccount * PERCENTAGE_OF_INVESTMANT + moneyForInvestment;
            if (i % 6 == 0) {
                salary += 400;
            }
        }
        return moneyInBrokerAccount;
    }

    private static double countSaving(double salary, int timeWork, double EXPENSES, double PERCENTAGE_OF_SALARY) {
        double moneyInSavingsAccount = 0; //в принципе она может быть и int, но надо ли делать интом?
        for (int i = 1; i <= timeWork; i++) {
            moneyInSavingsAccount += salary - EXPENSES - (salary - EXPENSES) * PERCENTAGE_OF_SALARY; //надо ли выносить в отдельную переменную salary - EXPENSES?
            if (i % 6 == 0) {
                salary += 400;
            }
        }
        return moneyInSavingsAccount;
    }
}
