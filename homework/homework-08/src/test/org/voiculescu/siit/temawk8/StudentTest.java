package org.voiculescu.siit.temawk8;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StudentTest {

    @Test
    void getAgeTest() {
        Student student = new Student("1", "1", "1", "23/09/1983", 'M');
        assertEquals(36, student.getAge());
    }

    @Test
    void StudentIDEmptyTest() {
        assertThrows(StudentException.class, () -> new Student("", "1", "1", "23/09/1983", 'F'));
    }

    @Test
    void StudentAgeBefore1900Test() {
        assertThrows(StudentException.class, () -> new Student("1", "1", "1", "23/09/1890", 'M'));
    }

    @Test
    void StudentAgeAfterTodayTest() {
        LocalDate date = LocalDate.now().plusDays(1);
        String dateOfBirth = date.format(DateTimeFormatter.ofPattern("dd/MM/uuuu"));
        assertThrows(StudentException.class, () -> new Student("1", "1", "1", dateOfBirth, 'M'));
    }

    @Test
    void StudentFirstNameEmptyTest() {
        assertThrows(StudentException.class, () -> new Student("1", "", "1", "23/09/1983", 'M'));
    }

    @Test
    void StudentLastNameEmptyTest() {
        assertThrows(StudentException.class, () -> new Student("1", "1", "", "23/09/1983", 'M'));
    }

    @Test
    void StudentInvalidGenderTest() {
        assertThrows(StudentException.class, () -> new Student("1", "1", "1", "23/09/1983", 'A'));
    }

    @Test
    void StudentInvalidDateTest() {
        assertThrows(StudentException.class, () -> new Student("1", "1", "1", "30/02/1983", 'M'));
    }

    @Test
    void StudentInvalidDateFormatTest() {
        assertThrows(StudentException.class, () -> new Student("1", "1", "1", "30/AA/1983", 'M'));
    }

}