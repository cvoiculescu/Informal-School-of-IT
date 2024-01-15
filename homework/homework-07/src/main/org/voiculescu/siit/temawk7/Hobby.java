package org.voiculescu.siit.temawk7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * this closs define a Hobby by it's name, the frecuency per week and the addresses where this hobby is practiced
 */
public class Hobby {
    private String name;
    private int frequency;
    private List<Address> addresses = new ArrayList<>();

    /**
     * This constructor defines the hobby by it's name and the frequency during a week
     * the adresses will be added separately
     *
     * @param name      hobby name
     * @param frequency hobby frequency
     */
    public Hobby(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    /**
     * returns the name of the hobby
     *
     * @return - name of the hobby
     */
    public String getName() {
        return name;
    }

    /**
     * returns the frequency the hobby is practiced
     *
     * @return - return how often the hobby is practiced
     */
    public int getFrequency() {
        return frequency;
    }

    /***
     * adds a new address where the hobby can be practiced. if the address is already in the list, this will not be added again
     * @param address - new address to be added
     * @return false if the addition was not made or true if it was made
     */
    public boolean addAddress(Address address) {
        if (addresses.contains(address)) {
            return false;
        }
        addresses.add(address);
        return true;
    }


    /**
     * this method will provide the addresses stored for the current hobby
     *
     * @return a list of hobbies
     */
    public List<Address> getAddresses() {
        return Collections.unmodifiableList(addresses);
    }

}
