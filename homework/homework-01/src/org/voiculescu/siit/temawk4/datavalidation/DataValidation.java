package org.voiculescu.siit.temawk4.datavalidation;

import java.util.Scanner;

/**
 * this class is to exemplify the validation of a time provide to the console
 */
public class DataValidation {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("What time is it? ");
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();
        if (isValid(hour, minute)) {
            System.out.println("The time is " + hour + ":" + minute + " now.");
        } else {
            System.out.println("Incorrect time!");
        }
    }

    /**
     * check if the provided time is valid (hours can be between 0 and 23 and minute between 0 and 59)
     *
     * @param hours   - this parameter is used to provide the hours of the time
     * @param minutes - this parameter is used to provide the minutes of the time
     * @return is true just if both the hours and minutes are valid
     */
    private static boolean isValid(int hours, int minutes) {
        if (hours < 0 || hours > 23) return false;
        return minutes >= 0 && minutes <= 59;
    }
}
