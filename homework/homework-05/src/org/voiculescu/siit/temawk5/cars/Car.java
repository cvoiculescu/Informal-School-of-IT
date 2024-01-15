package org.voiculescu.siit.temawk5.cars;

/**
 * Abstract class to define the generic vehicle
 */
public abstract class Car implements Vehicle {

    private final int fuelTankSize;
    private final FuelType fuelType;
    private final int numberOfGears;
    private final double consumptionPer100Km;
    private final String manufacturer;
    private final String make;
    private final double gearEff;
    private final String chassisNumber;
    private double availableFuel;
    private int tireSize;
    private int gear = 0;
    private boolean started = false;
    private double distance;
    private double fuelConsumed;
    private double averageConsumption;

    /**
     * initialize the Car
     *
     * @param manufacturer        - manufacturer of the Car
     * @param make                - make of the Car
     * @param fuelTankSize        - fuel tank size of the Car
     * @param fuelType            - fuel type the Car is using
     * @param numberOfGears       - the number of the gears
     * @param consumptionPer100Km - cruise fuel consumption per 100 km
     * @param availableFuel       - remaining fuel into the tank
     * @param tireSize            - the size of the tires the Car is equipped with
     * @param chassisNumber       - the chassis number for the Car
     * @param gearEff             - gearEff for each gear change
     */
    public Car(String manufacturer, String make, int fuelTankSize, FuelType fuelType, int numberOfGears, double consumptionPer100Km, double availableFuel, int tireSize, String chassisNumber, double gearEff) {
        this.fuelTankSize = fuelTankSize;
        this.fuelType = fuelType;
        this.numberOfGears = numberOfGears;
        this.consumptionPer100Km = consumptionPer100Km;
        this.availableFuel = availableFuel;
        this.tireSize = tireSize;
        this.chassisNumber = chassisNumber;
        this.manufacturer = manufacturer;
        this.make = make;
        this.gearEff = gearEff;
    }

    /**
     * returns the gear the car is at current state
     *
     * @return returns the current gear
     */
    public int getGear() {
        return gear;
    }

    /**
     * returns the manufacturer name for he current car
     *
     * @return the manufacturer name
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * returns the make of the current car
     *
     * @return the make of the car
     */
    public String getMake() {
        return make;
    }

    /**
     * changes the current gear to another gear
     * it will check if the gear is a valid one and if not will keep the current gear unchanged
     *
     * @param gear set the car into a new gear
     * @return if the gear change was made or not
     */
    public boolean shiftGear(int gear) {
        if (gear < 0 && gear > numberOfGears) {
            System.out.println("Rrrrr. Wrong gear");
            return false;
        }
        this.gear = gear;
        return false;
    }

    /**
     * checks if the car is started or not
     *
     * @return true if the car is started
     */
    private boolean isStarted() {
        return this.started;
    }

    /**
     * while the car starts all the parameters are reinitialised
     */
    @Override
    public void start() {
        this.started = true;
        this.fuelConsumed = 0;
        this.averageConsumption = 0;
        this.distance = 0;
    }

    /**
     * when the car stops, the average consumption is calculated
     */
    @Override
    public void stop() {
        this.started = false;
        averageConsumption = fuelConsumed / distance;
    }

    /**
     * based on the driven distance and the current gear, average fuel consumption will calculated
     *
     * @param distanceDriven - the distance the car made since was started
     */
    @Override
    public void drive(double distanceDriven) {
        if (isStarted()) {
            double calculatedPer100 = consumptionPer100Km * (1 + gearEff * (numberOfGears - getGear()));
            double consumed = distanceDriven * 100 / calculatedPer100;
            this.distance += distanceDriven;
            this.fuelConsumed += consumed;
            this.availableFuel -= consumed;
        } else {
            System.out.println("The car is not started.");
        }
    }

    /**
     * returns the tank size for the current car
     *
     * @return the maximum tank size
     */
    public int getFuelTankSize() {
        return fuelTankSize;
    }

    /**
     * returns the Fuel tpe used by the current car
     *
     * @return the fuel type the case is using
     */
    public FuelType getFuelType() {
        return fuelType;
    }

    /**
     * returns the number of gears
     *
     * @return the maximum gear
     */
    public int getNumberOfGears() {
        return numberOfGears;
    }

    /**
     * return the cruise consumption
     *
     * @return the cruise consumption for 100km
     */
    public double getConsumptionPer100Km() {
        return consumptionPer100Km;
    }

    /**
     * returns the remaining fuel in the tank
     *
     * @return the remaining fuel into the tank
     */
    public double getAvailableFuel() {
        return availableFuel;
    }

    /**
     * calculate the average fuel consumption based on the distance and consumption since car started
     *
     * @return the average fuel consumed
     */
    public double getAverageFuelConsumption() {
        return fuelConsumed / distance;
    }

    /**
     * return the size of the tire currently used
     *
     * @return the tire size the car is equipped with
     */
    public int getTireSize() {
        return tireSize;
    }

    /**
     * method used to change the size of the tires
     *
     * @param tireSize used to change the tire siez
     */
    public void setTireSize(int tireSize) {
        this.tireSize = tireSize;
    }

    /**
     * returns the chassis number
     *
     * @return the chassis number of the current car
     */
    public String getChassisNumber() {
        return chassisNumber;
    }


}
