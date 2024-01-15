package org.voiculescu.siit.temawk2;

import java.util.Scanner;

public class BiggestNumber {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Primul numar: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Al doilea numar: ");
        int secondNumber = scanner.nextInt();
        System.out.print("Al treilea numar: ");
        int thirdNumber = scanner.nextInt();
        System.out.println("Cel mai mare numar este: " + biggestNumber(firstNumber, secondNumber, thirdNumber));
    }

    private static int biggestNumber(int firstNumber, int secondNumber, int thirdNumber) {
        if (firstNumber >= secondNumber && firstNumber >= thirdNumber) {
            return firstNumber;
        } else {
            if (secondNumber >= firstNumber && secondNumber >= thirdNumber) {
                return secondNumber;
            } else {
                return thirdNumber;
            }
        }
    }
}
