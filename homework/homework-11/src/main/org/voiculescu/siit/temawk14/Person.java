package org.voiculescu.siit.temawk14;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Comparator;

/**
 * This class stores the data of a person, by first name, last name and birth date
 */
public class Person implements Comparable<Person> {
    /**
     * this constant is used to Parse a <b>String data</b> into a <b>LocalDate</b>
     */
    public static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd");
    String firstName;
    String lastName;
    LocalDate birthday;

    /**
     * defines a new Person with all fields as String
     *
     * @param firstName of a person
     * @param lastName  of a person
     * @param birthday  of a person
     */
    public Person(String firstName, String lastName, String birthday) {
        this(firstName, lastName, LocalDate.parse(birthday, FORMAT.withResolverStyle(ResolverStyle.STRICT)));
    }

    /**
     * defines a new Person with standard fields
     *
     * @param firstName of a person
     * @param lastName  of a person
     * @param birthday  of a person
     */
    public Person(String firstName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    /**
     * Compares two person by firstName and then by lastName
     *
     * @param o the person to compare with
     * @return -1,0 or 1 if this is by case smaller, equal or bigger
     */
    @Override
    public int compareTo(Person o) {
        return Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName).compare(this, o);
    }
}
