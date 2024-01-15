package org.voiculescu.siit.temawk7;

import java.util.Comparator;

/**
 * Comparator class which checks two persons based on the age
 */
public class PersonReverseAge implements Comparator<Person> {

    /**
     * the compare compare o2 with o1 in order to provide a descending order for components
     *
     * @param o1 the Persons compared
     * @param o2 - the Person compared with
     * @return a negative integer, zero, or a positive integer as the
     * first argument is greater than, equal to, or less than the
     * second.
     */
    @Override
    public int compare(Person o1, Person o2) {
        return o2.getAge().compareTo(o1.getAge());
    }
}
