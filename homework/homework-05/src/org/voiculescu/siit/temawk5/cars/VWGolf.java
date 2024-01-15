package org.voiculescu.siit.temawk5.cars;

/**
 * This class will be a VW car with "Golf" make
 */
public class VWGolf extends VW {

    /**
     * Initialize the VW car with "Golf" make
     *
     * @param availableFuel - the fuel quantity the car is initialized with
     * @param tireSize      - the size of the tires the car is equiped with
     * @param chassisNumber - the chassis number
     */
    public VWGolf(double availableFuel, int tireSize, String chassisNumber) {
        super("Golf", 52, FuelType.PETROL, 6, 4.7, availableFuel, tireSize, chassisNumber);
    }

}
