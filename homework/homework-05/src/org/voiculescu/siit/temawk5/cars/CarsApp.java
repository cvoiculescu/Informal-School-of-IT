package org.voiculescu.siit.temawk5.cars;

/**
 * the Main App to demonstrate the cars
 */
public class CarsApp {
    public static void main(String[] args) {
//    Car car = new Car();
//    Car car = new Dacia();
        Car car = new Logan(27, 15, "oiqe0934hkkadsn");
        car.start();
        car.shiftGear(1);
        car.drive(0.01);
        car.shiftGear(2);
        car.drive(0.02);
        car.shiftGear(3);
        car.drive(0.5);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(5);
        car.drive(10);
        car.shiftGear(4);
        car.drive(0.5);
        car.shiftGear(3);
        car.drive(0.1);
        car.stop();
        double availableFuel = car.getAvailableFuel();
        double fuelConsumedPer100Km = car.getAverageFuelConsumption();

        Vehicle vehicle = new VWGolf(30, 18, "1987ddkshik289");
        vehicle.start();
        vehicle.drive(1);
        vehicle.stop();
        car = (Car) vehicle;
        availableFuel = car.getAvailableFuel();
        fuelConsumedPer100Km = car.getAverageFuelConsumption();
    }
}
