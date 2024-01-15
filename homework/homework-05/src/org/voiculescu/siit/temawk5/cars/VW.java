package org.voiculescu.siit.temawk5.cars;

/**
 * VW is a Car with "Volkswagen" Manufacturer
 */
public abstract class VW extends Car {

    /**
     * initialize a "Vw" manufacturer Car
     *
     * @param make                - the make of the car
     * @param fuelTankSize        - the tank size will show how much fuel the "Vw" can have
     * @param fuelType            - the fuel type the "Vw" can use
     * @param gears               - the number of gears
     * @param consumptionPer100Km - how much the car consumes on cruise speed
     * @param availableFuel       - the remaining quantity of fuel in the tank
     * @param tireSize            - the size of the tires the car is equipped with
     * @param chassisNumber       - the chassis number of the car
     */
    public VW(String make, int fuelTankSize, FuelType fuelType, int gears, double consumptionPer100Km, double availableFuel, int tireSize, String chassisNumber) {
        super("Volkswagen", make, fuelTankSize, fuelType, gears, consumptionPer100Km, availableFuel, tireSize, chassisNumber, 0.05);
    }

}
