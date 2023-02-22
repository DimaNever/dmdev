package ru.getcourse.dmdev.homework.week4.encapsulation;

public class CashMachine {
    private final int FIFTY = 50;
    private final int TWENTY = 20;
    private final int TEN = 10;
    private int numberOfFifties;
    private int numberOfTwenties;
    private int numberOfTens;
    private int balance;

    public CashMachine(int numberOfFifties, int numberOfTwenties, int numberOfTens) {
        this.numberOfFifties = numberOfFifties;
        this.numberOfTwenties = numberOfTwenties;
        this.numberOfTens = numberOfTens;
        this.balance = this.numberOfFifties * FIFTY + this.numberOfTwenties * TWENTY + this.numberOfTens * TEN; // здесь можно и без this, но правильно ли?
    }

    public int getNumberOfFifties() {
        return numberOfFifties;
    }

    public int getNumberOfTwenties() {
        return numberOfTwenties;
    }

    public int getNumberOfTens() {
        return numberOfTens;
    }

    public int getBalance() {
        return balance;
    }

    public void printAccountBalance() {
        System.out.println("Account balance = " + this.balance);
    }

    public void addFifty(int amountFifty) {
        this.numberOfFifties += amountFifty;         //какой вариант предпостительнее? Этот?
        this.balance += amountFifty * FIFTY;
        printAccountBalance();
    }

    public void addTwenty(int amountTwenty) {
        this.numberOfTwenties = getNumberOfTwenties() + amountTwenty;          // или этот?
        this.balance = this.balance + amountTwenty * TWENTY;
        printAccountBalance();
    }

    public void addTen(int amountTen) {
        this.numberOfTens += amountTen;
        this.balance += amountTen * TEN;
        printAccountBalance();
    }

    public boolean isMoneyWithdrawn(int money) {
        if (money > this.balance) {
            System.out.println("Not enough funds in the account");
            return false;
        }
        if (money % 10 != 0) {
            System.out.println("Please enter the amount in multiples of 10");
            return false;
        }

        int countFifty = 0;
        int countTwenty = 0;
        int countTen = 0;

        while (money != 0) {
            while (money / FIFTY != 0) {
                this.balance -= FIFTY; //можно было завести доп переменную = money вначале и потом просто отнять её от баланса. Я хз что лучше будет работать.
                money -= FIFTY;
                countFifty++;
            }
            while (money / TWENTY != 0) {
                this.balance -= TWENTY;
                money -= TWENTY;
                countTwenty++;
            }
            while (money / TEN != 0) {
                this.balance -= TEN;
                money -= TEN;
                countTen++;
            }
        }
        System.out.println("Money issued:\nnumber of banknotes with a face value of 50 = " + countFifty +
                "\nnumber of banknotes with a face value of 20 = " + countTwenty +
                "\nnumber of banknotes with a face value of 10 = " + countTen);
        printAccountBalance();
        return true;
    }

    @Override
    public String toString() {
        return "CashMachine{" +
                "number of fifties = " + getNumberOfFifties() +
                ", number of twenties = " + getNumberOfTwenties() +
                ", number of tens = " + getNumberOfTens() +
                ", Account balance = " + getBalance() +
                '}';
    }
}
