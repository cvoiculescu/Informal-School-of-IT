package org.voiculescu.siit.temawk8;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * A class to define a Students
 */
public class Student {

    /*
    defining the logger from resources
     */
    private static final LogManager LOG_MANAGER = LogManager.getLogManager();
    private static final Logger LOGGER = Logger.getLogger(Student.class.getSimpleName());
    private static final String DATE_PATTERN_FORMAT = "dd/MM/uuuu";
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN_FORMAT);

    static {
        try {
            String path = Repository.class.getClassLoader().getResource("logging.properties").getFile();
            LOG_MANAGER.readConfiguration(new FileInputStream(path));
        } catch (IOException | NullPointerException exception) {
            LOGGER.log(Level.SEVERE, "Error in loading configuration", exception);
        }
    }

    private String ID;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private Gender gender;

    /**
     * Creates a new student based on following parameters
     *
     * @param ID          the ID provided to the new student
     * @param firstName   of the new created student
     * @param lastName    of the new created student
     * @param dateOfBirth should be of format dd/MM/yyyy
     * @param gender      should be M or F
     */
    public Student(String ID, String firstName, String lastName, String dateOfBirth, Character gender) {
        LOGGER.log(Level.INFO, "Starting student create");
        setID(ID);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
        LOGGER.log(Level.INFO, "Ending student create");
    }

    /**
     * @return the ID of the student
     */
    public String getID() {
        return ID;
    }

    /**
     * set the ID of the student. Used into Constructor
     *
     * @param ID the provided ID for the student
     */
    private void setID(String ID) {
        if (ID == null || ID.isEmpty()) {
            throw new StudentException("The ID cannot be empty of null");
        }
        this.ID = ID;
    }

    /**
     * @return te first name of the student
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * set the first name of the student. used into Constructor
     *
     * @param firstName provided to the constructor
     */
    private void setFirstName(String firstName) {
        if (firstName == null || firstName.isEmpty()) {
            String message = "The First name cannot be empty of null";
            LOGGER.log(Level.SEVERE, message);
            throw new StudentException(message);
        }
        this.firstName = firstName;
        LOGGER.log(Level.INFO, "First name set to: " + firstName);
    }

    /**
     * @return the last name of the student
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * set the last name. used in constructor
     *
     * @param lastName provided to the constructor
     */
    private void setLastName(String lastName) {
        if (lastName == null || lastName.isEmpty()) {
            String message = "The Last name cannot be empty of null";
            LOGGER.log(Level.SEVERE, message);
            throw new StudentException(message);
        }
        this.lastName = lastName;
        LOGGER.log(Level.INFO, "Last name set to: " + lastName);
    }

    /**
     * @return the date of birth as a string of format dd/MM/yyyy
     */
    public String getDateOfBirth() {
        LOGGER.log(Level.INFO, "Returned date of birth");
        return this.dateOfBirth.format(DateTimeFormatter.ofPattern(DATE_PATTERN_FORMAT));
    }

    /**
     * set the date of birth for the student. used into Constructor
     *
     * @param dateOfBirth date of birth like dd/MM/yyyy
     */
    private void setDateOfBirth(String dateOfBirth) {
        LocalDate date;
        LocalDate today = LocalDate.now();
        String message;
        try {
            date = LocalDate.parse(dateOfBirth, DATE_TIME_FORMATTER.withResolverStyle(ResolverStyle.STRICT));
        } catch (DateTimeParseException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage());
            throw new StudentException(ex.getMessage());
        }
        if (date.isAfter(today)) {
            message = "The birthday cannot be after today: " + today.format(DateTimeFormatter.ofPattern(DATE_PATTERN_FORMAT));
            LOGGER.log(Level.SEVERE, message);
            throw new StudentException(message);
        }
        if (date.getYear() < 1900) {
            message = "The birthday cannot be before year 1900.";
            LOGGER.log(Level.SEVERE, message);
            throw new StudentException(message);
        }
        this.dateOfBirth = date;
    }

    /**
     * calculates and return the age of the student compared with the actual date
     *
     * @return the age
     */
    public int getAge() {
        LOGGER.log(Level.INFO, "Calculated and returned the age");
        Period diff = Period.between(this.dateOfBirth, LocalDate.now());
        return diff.getYears();
    }

    /**
     * get the gender of the student
     *
     * @return a Gender
     */
    public Gender getGender() {
        LOGGER.log(Level.INFO, "Returned the gender");
        return this.gender;
    }

    /**
     * set the gender of the student. used in constructor
     *
     * @param gender provided to the constructor
     */
    private void setGender(Character gender) {
        Character temp = Character.toUpperCase(gender);
        if (!(temp.equals('M') || temp.equals('F'))) {
            String message = "Gender should be: " + Gender.male + " or " + Gender.female;
            LOGGER.log(Level.SEVERE, message);
            throw new StudentException(message);
        }
        switch (temp) {
            case 'M':
                this.gender = Gender.male;
                break;
            case 'F':
                this.gender = Gender.female;
                break;
        }
        LOGGER.log(Level.INFO, "Gender set to " + temp);
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth.format(DateTimeFormatter.ofPattern(DATE_PATTERN_FORMAT)) +
                ", gender=" + gender +
                '}';
    }

    /**
     * the equals will ve made based on the ID of the student
     *
     * @param o the object to compare with
     * @return the default equals of String Class (provided by getID())
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return getID().equals(student.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID());
    }
}
