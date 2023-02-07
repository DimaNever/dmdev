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
        final double PERSENTOFSALARY = 0.1;
        final double PERSENTOFINVESTMANT= 0.02;
        double moneyInBroker = 0;
        int timeWork = 38;
        double moneyForInvestment = 0;


        for (int i = 1; i <= timeWork; i++) {
            moneyForInvestment = (salary - 300) * PERSENTOFSALARY;
//            if (i == 1) {
//                moneyInBroker += moneyForInvestment;
//                continue;
//            }
            moneyInBroker += moneyInBroker * PERSENTOFINVESTMANT + moneyForInvestment;
            if (i % 6 == 0) {
                salary += 400;
            }
        }
    }

}
