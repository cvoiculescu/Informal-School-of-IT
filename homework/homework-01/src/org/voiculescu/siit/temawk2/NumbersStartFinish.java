package org.voiculescu.siit.temawk2;

import java.util.Scanner;

public class NumbersStartFinish {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Introduceti start-ul: ");
        int start = scanner.nextInt();
        System.out.print("Introduceti finish-ul: ");
        int finish = scanner.nextInt();
        if (start > finish) {
            System.out.println("Start-ul: " + start + " este mai mare decat Finish-ul: " + finish);
            return;
        }
        showNumbers(start, finish);
    }

    private static void showNumbers(int start, int finish) {
        System.out.println("Numerele cuprinse intre: " + start + " si " + finish + " sunt: ");
        for (int i = start; i <= finish; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
