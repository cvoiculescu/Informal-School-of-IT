package org.voiculescu.siit.temawk7;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ObjectContainersTest {

    @Test
    void printPersonHobbiesCountriesTest() {
        Person p = new Person("Test1", 1);
        Hobby h = new Hobby("ciclism", 1);
        Country c = new Country("Romania", "RO");
        Address a = new Address("TestStreet", c);
        h.addAddress(a);
        p.addHobby(h);
        Map<Person, List<Hobby>> personsWithHobbies = new HashMap<>();
        personsWithHobbies.put(p, p.getHobbies());
        Map<Hobby, Set<Country>> expectedMap = new HashMap<>();
        Set<Country> expectedSet = new HashSet<>();
        expectedSet.add(c);
        expectedMap.put(h, expectedSet);
        Map<Hobby, Set<Country>> hobbiesWithCountries = ObjectContainers.printPersonHobbiesCountries(personsWithHobbies, p);
        assertEquals(expectedMap.size(), hobbiesWithCountries.size());
    }

}