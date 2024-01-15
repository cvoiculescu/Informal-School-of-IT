package org.voiculescu.siit.temawk7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * This class defines a person through the name, age and the hobbies the person has.
 */
public class Person {
    private String name;
    private Integer age;
    private List<Hobby> hobbies = new ArrayList<>();

    /**
     * generates a new person through name an age. the hobbies can be added later through setters
     *
     * @param name - the persons name
     * @param age  - the persons age
     */
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * @return name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * @return the age of the person
     */
    public Integer getAge() {
        return age;
    }

    /**
     * add a hobby to a person. if the hobby exist already, then this will not be added
     *
     * @param hobby - the new hobby
     * @return - true if the hobby was added and false if not
     */
    public boolean addHobby(Hobby hobby) {
        if (hobbies.contains(hobby)) {
            return false;
        }
        hobbies.add(hobby);
        return true;
    }

    /**
     * remove the hobby as object
     *
     * @param hobby - the instantiated object of type Hobby
     * @return true if the object removed or false if not
     */
    public boolean removeHobby(Hobby hobby) {
        if (hobbies.contains(hobby)) {
            hobbies.remove(hobby);
            return true;
        }
        return false;
    }

    /**
     * remove a hobby by the index of that hobby
     *
     * @param index the record index of the hobby
     * @return true if hobby removed or false if not
     */
    public boolean removeHobby(int index) {
        if (index >= 0 && index < hobbies.size()) {
            hobbies.remove(index);
            return true;
        }
        return false;
    }

    /**
     * return the index of a hobby
     *
     * @param name the name of the hobby searched for
     * @return the index of the hobby, or -1 if no hobby found
     */
    public int getHobbyIndex(String name) {
        for (int index = 0; index < hobbies.size(); index++) {
            if (hobbies.get(index).getName().equals(name)) return index;
        }
        return -1;
    }

    /**
     * this method searches the hobby by name and if hobby found then it will be removed
     *
     * @param name the name of the hobby
     * @return true if hobby removed and false if not
     */
    public boolean removeHobby(String name) {
        int index = getHobbyIndex(name);
        if (index >= 0) {
            hobbies.remove(index);
            return true;
        }
        return false;
    }

    /**
     * returns a list with the hobbies of current person
     *
     * @return a unmodifiable list of hobbies that person has
     */
    public List<Hobby> getHobbies() {
        return Collections.unmodifiableList(hobbies);
    }


    /**
     * the equal is made through the name of the person.
     *
     * @param o the object compared to
     * @return true if the objects are the same and false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
