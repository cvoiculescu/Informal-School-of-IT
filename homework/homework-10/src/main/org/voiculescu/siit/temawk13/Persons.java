package org.voiculescu.siit.temawk13;

import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

/**
 * this class is used to store the persons
 */
public class Persons {

    public static final String SOURCE_PATH = "files/input/";
    public static final String OUTPUT_PATH = "files/output/";
    private List<Person> persons = new Vector<>();

    /**
     * this method will read both files in one single thread
     *
     * @return the time in miliseconds needed to read all the contents from files
     * @throws InterruptedException if the reading thread is interrupted
     */
    public long readSingleThreadTime() throws InterruptedException {
        persons.clear();
        long currentTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            readFile(SOURCE_PATH + "file1.txt");
            readFile(SOURCE_PATH + "file2.txt");
        });
        t1.start();
        t1.join();
        return System.currentTimeMillis() - currentTime;
    }

    /**
     * this method read the files in different threads, which are run in parallel
     *
     * @return the time in miliseconds needed to load both files
     * @throws InterruptedException if the reading threads are interrupted
     */
    public long readTwoThreadsTime() throws InterruptedException {
        persons.clear();
        long currentTime = System.currentTimeMillis();
        Thread t1 = new Thread(() -> {
            readFile(SOURCE_PATH + "file1.txt");
        });
        Thread t2 = new Thread(() -> {
            readFile(SOURCE_PATH + "file2.txt");
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return System.currentTimeMillis() - currentTime;
    }

    /**
     * this method read Persons from file and the parse those into Person objects
     *
     * @param filename is the relative file path to the file to be read from
     */
    private void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",");
                persons.add(Person.parsePerson(splitLine[0], splitLine[1], splitLine[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> getPersons() {
        return persons;
    }

    /**
     * this method will print the Persons of  gender female which have the birthday today
     *
     * @throws IOException if the outfile is missing
     * @see Gender
     * @see Person
     */
    public void getTodayBornWomen() throws IOException {
        LocalDate today = LocalDate.now();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_PATH + "output.txt"))) {
            persons.stream().filter((person) -> {
                LocalDate birthDate = person.getBirthDate();
                if (person.getGender() == Gender.male) return false;
                return birthDate.getDayOfMonth() == today.getDayOfMonth() &&
                        birthDate.getMonth() == today.getMonth();
            }).forEach(persons -> {
                String message = "Happy birthday " + persons.getName() + " (" + persons.getBirthDate().getYear() + ")";
                System.out.println(message);
                try {
                    writer.write(message + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}
