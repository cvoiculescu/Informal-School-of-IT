package org.voiculescu.siit.temawk14;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PersonTest {

    /**
     * Test if a person created with a string birthday is created properly
     */
    @Test
    public void PersonTest() {
        Person person = new Person("Corneliu", "Voiculescu", "1983-09-23");
        LocalDate date = LocalDate.of(1983, 9, 23);
        assertEquals(date, person.getBirthday());
    }

    /**
     * checks if the comparision of two persons is done both on firstName and lastName
     */
    @Test
    public void compareToTest() {
        Person person1 = new Person("a", "b", "1983-09-23");
        Person person2 = new Person("a", "c", "1983-09-23");
        assertTrue(person1.compareTo(person2) < 0);
        person1 = new Person("a", "a", "1983-09-23");
        person2 = new Person("c", "a", "1983-09-23");
        assertTrue(person1.compareTo(person2) < 0);
        assertTrue(person1.compareTo(person1) == 0);
    }

}