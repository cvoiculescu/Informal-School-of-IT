package org.voiculescu.siit.temawk8;

import java.util.List;

public class MainApp {
    private static Repository rep = new Repository();

    public static void main(String[] args) {

        try {
            rep.addStudent("1", "1", "1", "23/09/1983", 'M');
        } catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }
        try {
            rep.addStudent("1", "1", "1", "23/09/1983", 'M');
        } catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }
        try {
            rep.addStudent("2", "2", "2", "23/09/1983", 'M');
        } catch (RepositoryException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Show students of age: 36");
        List<Student> studentsWithAge = rep.getStudentsOfAge(36);
        System.out.println(studentsWithAge);
    }
}
