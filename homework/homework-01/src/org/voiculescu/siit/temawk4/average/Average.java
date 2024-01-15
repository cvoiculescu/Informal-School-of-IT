package org.voiculescu.siit.temawk4.average;

import java.util.Scanner;

/**
 * this class is used to show an example of calculating the average of the elements of an array
 */
public class Average {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = readNumbers();
        double average = getAverage(numbers);
        System.out.println("The average is " + String.format("%.2f", average));
    }

    /**
     * this method will read from keyboard the number of elements of a new array and then will read each element
     *
     * @return an array of integers
     */
    private static int[] readNumbers() {
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] readNumbers = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            readNumbers[i] = scanner.nextInt();
        }
        return readNumbers;
    }

    /**
     * this method will return the average of the components of an int array
     *
     * @param listOfNumbers the list of numbers for which we need the average
     * @return return a double with the value of the average
     */
    private static double getAverage(int[] listOfNumbers) {
        int sum = 0;
        for (int number : listOfNumbers) {
            sum += number;
        }
        return (double) sum / (double) listOfNumbers.length;
    }
}
