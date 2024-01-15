package org.voiculescu.siit.temawk4.duplicates;

import java.util.Arrays;
import java.util.Scanner;

/**
 * this class is used to demonstrate how to remove duplicates from an array
 */
public class Duplicates {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = readNumbers();
        System.out.println("Numbers with duplicates: " + Arrays.toString(numbers));
        int[] noDuplicates = removeDuplicates(numbers);
        System.out.println("Numbers without duplicates: " + Arrays.toString(noDuplicates));
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
     * this method will find the duplicates into the provided array and will remove those
     * Once an element will be found as not duplicate the index will be increased and that non duplicate will be moved into the new index.
     * So the duplicates will be overwritten with new values, and at the end the index will provide the size of a new array.
     *
     * @param numbers - the array with duplicates
     * @return - will return a new array without duplicates
     */
    private static int[] removeDuplicates(int[] numbers) {
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (numbers[i] == numbers[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                numbers[index] = numbers[i];
                index++;
            }
        }
        return Arrays.copyOfRange(numbers, 0, index);
    }
}
