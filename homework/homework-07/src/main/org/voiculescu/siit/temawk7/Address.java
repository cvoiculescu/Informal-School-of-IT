package org.voiculescu.siit.temawk7;

/**
 * this class is used to store the location by Country and street addres
 */
public class Address {
    private String street;
    private Country country;

    /**
     * generates a new address based on street name and country
     *
     * @param street  - the street name of the address
     * @param country - the Country of the address
     */
    public Address(String street, Country country) {
        this.street = street;
        this.country = country;
    }

    /**
     * @return the name of the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @return the Country the actual address is in
     */
    public Country getCountry() {
        return country;
    }
}
