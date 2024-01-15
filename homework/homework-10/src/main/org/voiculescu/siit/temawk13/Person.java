package org.voiculescu.siit.temawk13;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

/**
 * This class defines a Person through the name, date of birth and gender
 */
public class Person {

    private static DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("uuuu-MM-dd");

    private String name;
    private LocalDate birthDate;
    private Gender gender;

    /**
     * defines a new Person
     *
     * @param name      the name of the person
     * @param birthDate the date of birth of format uuuu-MM-dd
     * @param gender    the gender can be either male or female
     * @see Gender
     */
    public Person(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    /**
     * this method is used to convert String values in a new Person
     *
     * @param nameValue        the name of the person which needs to be created
     * @param dateOfBirthValue the date of birth of the person, of format yyyy-MM-dd
     * @param genderValue      can be defined either with numbers (0 for male and 1 for female) of by the names
     * @return a new Person according to the provided data
     * @throws IllegalArgumentException if the values <b>dateOfBirth</b> and <b>genderValue</b> are wronly provided
     */
    public static Person parsePerson(String nameValue, String dateOfBirthValue, String genderValue) {
        LocalDate dateOfBirth;
        try {
            dateOfBirth = LocalDate.parse(dateOfBirthValue, DATE_FORMAT.withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Wrong dateOfBirth argument: " + dateOfBirthValue + ". Should be of format: uuuu-MM-dd");
        }
        Gender gender;
        try {
            gender = Gender.valueOf(genderValue);
        } catch (IllegalArgumentException e) {
            try {
                int numerical = Integer.parseInt(genderValue);
                if (numerical > 1) {
                    throw new IllegalArgumentException("Wrong gender argument: " + genderValue + ". Should be either 0 or 1");
                }
                gender = Gender.values()[numerical];
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Wrong gender argument: " + genderValue + ". Should be either 0 or 1");
            }
        }
        Person person = new Person(nameValue, dateOfBirth, gender);
        return person;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }
}
