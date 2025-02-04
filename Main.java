package oop;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Television tv = new Television();

    public static void main(String[] args) {
        turnOnTv(); // İlk açılışta sadece TV açma seçeneği var.

        boolean exit = false;
        while (!exit) {
            showMenu();
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();

            if (!tv.isSetupCompleted() && choice != 1 && choice != 5) {
                System.out.println("Please complete TV setup first.");
                continue;
            }

            switch (choice) {
                case 1 -> increaseTvVolume();
                case 2 -> decreaseTvVolume();
                case 3 -> changeTvChannel();
                case 4 -> showTvChannelInfo();
                case 5 -> {
                    turnOffTv();
                    exit = true;
                }
                default -> System.out.println("Please enter a valid option.");
            }
        }
    }

    private static void turnOnTv() {
        System.out.println("Welcome! You need to turn on the TV first.");
        tv.turnOn();
        setupTv(); // TV açılır açılmaz otomatik kurulum yapılır.
    }

    private static void setupTv() {
        if (!tv.isSetupCompleted()) {
            tv.setupTv();
        }
    }

    private static void turnOffTv() {
        tv.turnOff();
    }

    private static void increaseTvVolume() {
        tv.increaseVolume();
    }

    private static void decreaseTvVolume() {
        tv.decreaseVolume();
    }

    private static void changeTvChannel() {
        System.out.print("Enter channel number: ");
        int channel = scanner.nextInt();
        tv.changeChannel(channel);
    }

    private static void showTvChannelInfo() {
        tv.showActiveChannel();
    }

    private static void showMenu() {
        System.out.println("***** MENU *****");
        if (!tv.isSetupCompleted()) {
            System.out.println("1 - Setup TV\n5 - Turn Off TV");
        } else {
            System.out.println("1 - Increase Volume\n2 - Decrease Volume\n3 - Change Channel\n4 - Show Channel Info\n5 - Turn Off TV");
        }
    }
}
