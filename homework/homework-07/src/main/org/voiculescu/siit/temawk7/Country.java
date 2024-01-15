package org.voiculescu.siit.temawk7;

/**
 * this class contains the naming and the code of a country
 */
public class Country {
    private String name;
    private String code;

    /**
     * generates a country based on country code and country name
     *
     * @param name - the name of the Country
     * @param code - the code of the Country
     */
    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    /**
     * @return the name of the country
     */
    public String getName() {
        return name;
    }

    /**
     * @return the code of the country
     */
    public String getCode() {
        return code;
    }
}
