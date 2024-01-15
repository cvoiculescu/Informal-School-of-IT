package org.voiculescu.siit.temawk4.temperature;

import java.util.Scanner;

/**
 * this class is used to show the conversion from Fahrenheit degrees to Celsius degrees
 */
public class Temperature {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Give body temperature in F: ");
        double temperature = scanner.nextDouble();
        double convertedTemperature = convertFahrenheitToCelsius(temperature);
        System.out.println("Your body temperature in Celsius degrees is " + String.format("%.2f", convertedTemperature));
        if (convertedTemperature > 37) {
            System.out.println("You are ill!");
        }
    }

    /**
     * This method will convert the provided temperature provided in F into C
     *
     * @param fTemp this is the input Fahrenheit temperature which needs to be converted
     * @return this method will return the temperature in C degrees
     */
    private static double convertFahrenheitToCelsius(double fTemp) {
        return (fTemp - 32) * 5 / 9;
    }
}
