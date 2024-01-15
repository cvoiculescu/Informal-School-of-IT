package org.voiculescu.siit.temawk2;

import java.util.Scanner;

public class Palindrome {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Dati numarul: ");
        int number = scanner.nextInt();
        System.out.println("Numarul " + number + (palindrome(number) ? " este " : " nu este ") + "palindrom");
    }

    public static boolean palindrome(int number) {
        boolean isPalindrome = true;
        String numberString = Integer.toString(number);
        for (int i = 0; i < numberString.length(); i++) {
            if (numberString.charAt(i) != numberString.charAt(numberString.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}
