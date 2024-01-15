package org.voiculescu.siit.temawk8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * creates a repository of students and provide functionality to add and remove students
 */
public class Repository {

    /*
    defining the Logger
     */
    private static final LogManager LOG_MANAGER = LogManager.getLogManager();
    private static final Logger LOGGER = Logger.getLogger(Repository.class.getSimpleName());

    static {
        try {
            String path = Repository.class.getClassLoader().getResource("logging.properties").getFile();
            LOG_MANAGER.readConfiguration(new FileInputStream(path));
        } catch (IOException | NullPointerException exception) {
            LOGGER.log(Level.SEVERE, "Error in loading configuration", exception);
        }
    }

    /*
    the students will ve stored into an ArrayList
     */
    private List<Student> students = new ArrayList<>();

    /**
     * Adds a student to the repository
     *
     * @param studentID   provided by the user
     * @param firstName   of the student
     * @param lastName    of the student
     * @param dateOfBirth of the student
     * @param gender      of the student
     * @throws RepositoryException if the student is either invalid or it exists already in the repository
     */
    public void addStudent(String studentID, String firstName, String lastName, String dateOfBirth, Character gender) {
        Student newStudent;
        try {
            newStudent = new Student(studentID, firstName, lastName, dateOfBirth, gender);
        } catch (StudentException e) {
            String message = "Student not added: " + e.getMessage();
            LOGGER.log(Level.SEVERE, message);
            throw new RepositoryException(message);
        }
        if (students.contains(newStudent)) {
            String message = "Student not added: " + "This student already exists";
            LOGGER.log(Level.SEVERE, message);
            throw new RepositoryException(message);
        }
        students.add(newStudent);
        LOGGER.log(Level.INFO, "Student " + newStudent + " added to repository");
    }

    /**
     * deletes a student based on the student ID
     *
     * @param studentID of the student
     * @throws RepositoryException if the studentID is not found or if the provided studentID is empty
     */
    public void deleteStudent(String studentID) {
        String message;
        if (studentID.isEmpty()) {
            message = "Student ID cannot be empty";
            LOGGER.log(Level.SEVERE, message);
            throw new RepositoryException(message);
        }
        Student studentByID = getStudentByID(studentID);
        if (studentByID == null) {
            message = "Student not deleted: " + studentID + " is not in our repository";
            LOGGER.log(Level.SEVERE, message);
            throw new RepositoryException(message);
        }
        students.remove(studentByID);
        LOGGER.log(Level.INFO, "Student " + studentByID.toString() + " removed");
    }

    /**
     * provides a list of students whose age are <b>age</b>
     *
     * @param age which the repository to be filtered by
     * @return a list of filtered students
     * @throws RepositoryException if age is not a positive number
     */
    public List<Student> getStudentsOfAge(int age) {
        String message;
        if (age < 0) {
            message = "Age cannot be negative";
            LOGGER.log(Level.SEVERE, message);
            throw new RepositoryException(message);
        }
        List<Student> generatedList = new ArrayList<>();
        students.forEach(student -> {
            int tempAge = student.getAge();
            if (tempAge == age) generatedList.add(student);
        });
        LOGGER.log(Level.INFO, "List of students of age " + age + " generated");
        return generatedList;
    }

    /**
     * returns the student if the id is found into the <b>students</b> list
     *
     * @param id the student ID
     * @return the Student object
     */
    private Student getStudentByID(String id) {
        for (Student student : students
        ) {
            if (student.getID().contentEquals(id)) return student;
        }
        return null;
    }

}
