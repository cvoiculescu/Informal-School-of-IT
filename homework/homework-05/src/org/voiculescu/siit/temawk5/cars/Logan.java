package org.voiculescu.siit.temawk5.cars;

/**
 * Class used to Initialize a "Dacia" car with "Logan" Make
 */
public class Logan extends Dacia {

    /**
     * Initializes a "Dacia" with "Logan" Make
     *
     * @param availableFuel - the remaining fuel in the car
     * @param tireSize      - the size of the tires the "Logan" is equipped with
     * @param chassisNumber - the chassis number of the current car
     */
    public Logan(double availableFuel, int tireSize, String chassisNumber) {
        super("Logan", 52, FuelType.PETROL, 6, 4.7, availableFuel, tireSize, chassisNumber);
    }

}
