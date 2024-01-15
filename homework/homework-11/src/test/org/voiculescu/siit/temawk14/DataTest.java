package org.voiculescu.siit.temawk14;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Tests for Data class
 */
class DataTest {

    /**
     * test if the List is sorted properly, by firstName and lastName
     */
    @Test
    public void sortByFirstAndLastNameTest() {
        Data data = new Data();
        Person person1 = new Person("Ioana", "Voiculescu", LocalDate.of(1989, 1, 7));
        Person person2 = new Person("Corneliu", "Voiculescu", LocalDate.of(1983, 9, 23));
        List<Person> persons = Arrays.asList(person1, person2);
        List<Person> people = data.sortByFirstAndLastName(persons);
        assertEquals(person2, people.get(0));
    }

    /**
     * test if the filter is done properly by the month of the year
     */
    @Test
    public void filterByBirthdayMonthTest() {
        Data data = new Data();
        Person person1 = new Person("Ioana", "Voiculescu", LocalDate.of(1989, 1, 7));
        Person person2 = new Person("Corneliu", "Voiculescu", LocalDate.of(1983, 9, 23));
        List<Person> persons = Arrays.asList(person1, person2);
        List<Person> people = data.filterByBirthdayMonth(persons, 9);
        assertEquals(person2, people.get(0));
        assertEquals(1, people.size());
    }

}