package org.voiculescu.siit.temawk13;

import java.io.IOException;

/**
 * the Main method is checking the differences of time between single thread reads of the files and double thread reads<br>
 * also, this will show a list with the women born today
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Persons persons = new Persons();
        System.out.println("Single thread read time: " + persons.readSingleThreadTime());
        System.out.println("Two threads read time: " + persons.readTwoThreadsTime());
        persons.getTodayBornWomen();
    }
}
