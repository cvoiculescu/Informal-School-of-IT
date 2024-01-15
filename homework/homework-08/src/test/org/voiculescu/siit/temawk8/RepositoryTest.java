package org.voiculescu.siit.temawk8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RepositoryTest {

    @Test
    void addStudentInvalidDataTest() {
        Repository repository = new Repository();
        assertThrows(RepositoryException.class, () -> repository.addStudent("", "1", "1", "23/09/1983", 'M'));
    }

    @Test
    void addStudentExistingStudentTest() {
        Repository repository = new Repository();
        repository.addStudent("1", "1", "1", "23/09/1983", 'M');
        assertThrows(RepositoryException.class, () -> repository.addStudent("1", "1", "1", "23/09/1983", 'M'));
    }

    @Test
    void deleteStudentWrongIDTest() {
        Repository repository = new Repository();
        repository.addStudent("1", "1", "1", "23/09/1983", 'M');
        assertThrows(RepositoryException.class, () -> repository.deleteStudent("2"));
    }

    @Test
    void deleteStudentEmptyIDTest() {
        Repository repository = new Repository();
        repository.addStudent("1", "1", "1", "23/09/1983", 'M');
        assertThrows(RepositoryException.class, () -> repository.deleteStudent(""));
    }

    @Test
    void getStudentsOfAgeTest() {
        Repository repository = new Repository();
        repository.addStudent("1", "1", "1", "23/09/1983", 'M');
        repository.addStudent("2", "2", "2", "23/09/1982", 'M');
        repository.addStudent("3", "3", "3", "23/09/1983", 'M');
        assertEquals(2, repository.getStudentsOfAge(36).size());
    }

    @Test
    void getStudentsOfAgeNegativeTest() {
        Repository repository = new Repository();
        repository.addStudent("1", "1", "1", "23/09/1983", 'M');
        assertThrows(RepositoryException.class, () -> repository.getStudentsOfAge(-1));
    }

    @Test
    void deleteStudentTest() {
        Repository repository = new Repository();
        repository.addStudent("1", "1", "1", "23/09/1983", 'F');
        repository.deleteStudent("1");
        assertThrows(RepositoryException.class, () -> repository.deleteStudent("1"));
    }


}