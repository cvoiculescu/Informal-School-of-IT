package org.voiculescu.siit.temawk14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * this class is used to store the data of many Persons
 *
 * @see Person
 */
public class Data {

    private List<Person> persons = new ArrayList<>();

    /**
     * this methods loads data form external file, sort and filter and after write the resulting data into external file
     *
     * @param input       the file the data is read from
     * @param targetMonth the target month to filter the persons
     * @param output      the file the data is written to
     */
    public void sortAndFilter(String input, int targetMonth, String output) {
        loadFromFile(input);
        List<Person> filteredPersons = filterByBirthdayMonth(persons, targetMonth);
        List<Person> sortedPersons = sortByFirstAndLastName(filteredPersons);
        saveToFile(sortedPersons, output);
    }

    /**
     * this method is used to load the data from file
     *
     * @param filename the file the data is read from
     * @return true if the read was made
     */
    public boolean loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader("files" + File.separator + filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitLine = line.split(",");
                String firstName = (splitLine[0].split(" "))[0];
                String lastName = (splitLine[0].split(" "))[1];
                String birthDate = splitLine[1];
                persons.add(new Person(firstName, lastName, birthDate));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * this method is used to save the data to file
     *
     * @param personList the  list to be written onto file
     * @param filename   the output file to write to
     * @return true if the save was made without error
     */
    public boolean saveToFile(List<Person> personList, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("files" + File.separator + filename))) {
            for (Person person : personList) {
                writer.write(person.getFirstName() + ", " + person.getLastName() + " " + person.getBirthday() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * This method sorts the list by the fields firstName, and then lastName
     * The sort is made by the Comparable method into the Person class
     *
     * @param personList the list to be sorted
     * @return a sorted list
     * @see Person
     */
    public List<Person> sortByFirstAndLastName(List<Person> personList) {
        ArrayList<Person> sortedPersons = personList.stream()
                .sorted().collect(Collectors.toCollection(ArrayList::new));
        return sortedPersons;
    }

    /**
     * filtering a list of Persons by the month of the year
     *
     * @param personList the list to be filtered
     * @param month      the filter to be applied
     * @return a filtered list of persons
     */
    public List<Person> filterByBirthdayMonth(List<Person> personList, int month) {
        ArrayList<Person> filteredPersons = personList.stream()
                .filter(person -> person.getBirthday().getMonth().getValue() == month)
                .collect(Collectors.toCollection(ArrayList::new));
        return filteredPersons;
    }
}
