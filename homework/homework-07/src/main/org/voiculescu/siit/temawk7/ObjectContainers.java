package org.voiculescu.siit.temawk7;

import java.util.*;

/**
 * Main app that test the functionality of the classes
 */
public class ObjectContainers {
    public static void main(String[] args) {
        System.out.println("Section 1 of the homework: ");
        Set<Person> persons = new TreeSet<>(new PersonReverseAge());
        persons.add(new Person("Corneliu", 36));
        persons.add(new Person("Ioana", 30));
        persons.add(new Person("Ion", 60));
        persons.add(new Person("Vasile", 31));
        persons.forEach((p) -> System.out.println(p.getName() + " " + p.getAge()));

        System.out.println("\nSection 2 of the homework: ");
        Map<Person, List<Hobby>> personsWithHobbies = new HashMap<>();
        Country romania = new Country("Romania", "RO");
        Country usa = new Country("United States of America", "US");
        Country uk = new Country("United Kingdom", "UK");
        Address address1 = new Address("Strada 1", romania);
        Address address2 = new Address("Strada 2", romania);
        Address address3 = new Address("Street1", usa);
        Address address4 = new Address("Street 1", usa);
        Address address5 = new Address("London Road", uk);

        Hobby ciclism = new Hobby("Ciclism", 2);
        ciclism.addAddress(address1);
        ciclism.addAddress(address2);
        ciclism.addAddress(address5);
        Hobby parasutism = new Hobby("Parasutism", 1);
        parasutism.addAddress(address3);
        parasutism.addAddress(address4);
        Person corneliu = new Person("Corneliu", 36);
        corneliu.addHobby(ciclism);
        Person ioana = new Person("Ioana", 30);
        ioana.addHobby(parasutism);
        personsWithHobbies.put(corneliu, corneliu.getHobbies());
        personsWithHobbies.put(ioana, ioana.getHobbies());

        printPersonHobbiesCountries(personsWithHobbies, corneliu);
    }

    public static Map<Hobby, Set<Country>> printPersonHobbiesCountries(Map<Person, List<Hobby>> personsWithHobbies, Person person) {
        Map<Hobby, Set<Country>> result = new HashMap<>();
        Set<Person> persons = personsWithHobbies.keySet();
        if (!persons.contains(person)) {
            System.out.println("This person in not in the list");
            return null;
        }
        List<Hobby> hobbies = personsWithHobbies.get(person);
        hobbies.forEach(hobby -> {
            Set<String> countryCodes = new HashSet<>();
            System.out.println("Hobby Name: " + hobby.getName());
            System.out.print("Locations: ");
            List<Address> addresses = hobby.getAddresses();
            addresses.forEach(address -> {
                countryCodes.add(address.getCountry().getCode());
                Set<Country> countries = result.get(hobby);
                if (countries == null) {
                    countries = new HashSet<>();
                }
                countries.add(address.getCountry());
                result.put(hobby, countries);
            });
            countryCodes.forEach((countryCode) -> System.out.print(countryCode + " "));
            System.out.println();
        });
        return result;
    }
}
