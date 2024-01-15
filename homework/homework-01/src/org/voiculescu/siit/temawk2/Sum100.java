package org.voiculescu.siit.temawk2;

public class Sum100 {

    public static void main(String[] args) {
        System.out.println("Suma primelor 100 numere naturale nenule este: " + sum100());
    }

    private static int sum100() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
