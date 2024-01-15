package org.voiculescu.siit.temawk4.maxnumbers;

import java.util.Scanner;

/**
 * this class shows the biggest between 3 numbers
 */
public class MaxNumbers {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter first number: ");
        int firstNumber = scanner.nextInt();
        System.out.print("Enter second number: ");
        int secondNumber = scanner.nextInt();
        System.out.print("Enter third number: ");
        int thirdNumber = scanner.nextInt();
        System.out.println("The biggest number is: " + getMax(firstNumber, getMax(secondNumber, thirdNumber)));
    }

    /**
     * returns the value of the biggest number between two integers: number1 and number2
     *
     * @param number1 - first number
     * @param number2 - second number
     * @return this will return the value which is biggest between number1 and number 2
     */
    public static int getMax(int number1, int number2) {
        return Math.max(number1, number2);
    }
}
