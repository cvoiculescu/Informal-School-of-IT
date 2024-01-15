package org.voiculescu.siit.temawk13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * this class is defined to test the Person class
 *
 * @see Person
 */
class PersonTest {

    /**
     * test if the new created person is working properly with male/female gender
     */
    @Test
    void parsePersonWithAlphaGenderTest() {
        Person person = Person.parsePerson("Corneliu", "1983-09-23", "male");
        assertEquals(Gender.male, person.getGender());
    }

    /**
     * test if the new created person is working properly with 0/1 gender
     */
    @Test
    void parsePersonWithNumericGenderTest() {
        Person person = Person.parsePerson("Corneliu", "1983-09-23", "0");
        assertEquals(Gender.male, person.getGender());
    }

    /**
     * test if the parse is failing if wrong gender is provided
     */
    @Test
    void parsePersonWithWrongGenderTest() {
        assertThrows(IllegalArgumentException.class, () -> Person.parsePerson("Corneliu", "1983-09-23", "2"));
        assertThrows(IllegalArgumentException.class, () -> Person.parsePerson("Corneliu", "1983-09-23", "Male"));
    }

    /**
     * test if the parse if failing if wrong date of birth is provided
     */
    @Test
    void parsePersonWithDayOfBirthTest() {
        assertThrows(IllegalArgumentException.class, () -> Person.parsePerson("Corneliu", "1983-09-50", "male"));
    }
}