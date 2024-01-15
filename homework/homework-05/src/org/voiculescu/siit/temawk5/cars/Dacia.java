package org.voiculescu.siit.temawk5.cars;

/**
 * Dacia is a Car with "Dacia" Manufacturer
 */
public abstract class Dacia extends Car {

    /**
     * initialize a "Dacia" manufacturer Car
     *
     * @param make                - the make of the car
     * @param fuelTankSize        - the tank size will show how much fuel the "Dacia" can have
     * @param fuelType            - the fuel type the "Dacia" can use
     * @param gears               - the number of gears
     * @param consumptionPer100Km - how much the car consumes on cruise speed
     * @param availableFuel       - the remaining quantity of fuel in the tank
     * @param tireSize            - the size of the tires the car is equipped with
     * @param chassisNumber       - the chassis number of the car
     */
    public Dacia(String make, int fuelTankSize, FuelType fuelType, int gears, double consumptionPer100Km, double availableFuel, int tireSize, String chassisNumber) {
        super("Dacia", make, fuelTankSize, fuelType, gears, consumptionPer100Km, availableFuel, tireSize, chassisNumber, 0.05);
    }

}
