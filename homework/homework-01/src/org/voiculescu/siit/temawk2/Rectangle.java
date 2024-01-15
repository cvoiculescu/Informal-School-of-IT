package org.voiculescu.siit.temawk2;

import java.util.Scanner;

public class Rectangle {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduceti lungimea: ");
        int length = scanner.nextInt();
        int width = scanner.nextInt();
        if (width < 0 || length < 0) {
            System.out.println("Dimensiunile trebuie sa fie pozitive");
            return;
        }
        System.out.println("Aria este: " + rectangleArea(width, length));
        System.out.println("Perimetrul este: " + rectanglePerimeter(width, length));
    }

    public static int rectangleArea(int width, int length) {
        return width * length;
    }

    public static int rectanglePerimeter(int width, int length) {
        return 2 * width + 2 * length;
    }
}
