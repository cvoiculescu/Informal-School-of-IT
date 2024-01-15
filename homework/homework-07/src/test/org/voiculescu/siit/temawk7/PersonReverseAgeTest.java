package org.voiculescu.siit.temawk7;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonReverseAgeTest {

    @Test
    void compare() {
        TreeSet<Person> persons = new TreeSet<>(new PersonReverseAge());
        persons.add(new Person("Test1", 10));
        persons.add(new Person("Test2", 12));
        assertEquals(12, persons.first().getAge());
    }
}