package org.voiculescu.siit.temawk5.cars;

/**
 * an interface which ensure the general behavior of a vehicle
 */
public interface Vehicle {
    void start();

    void stop();

    void drive(double distance);
}
