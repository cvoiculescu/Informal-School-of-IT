package org.voiculescu.siit.temawk5.cars;

/**
 * enum used to define the fuel types
 */
public enum FuelType {
    DIESEL {
        @Override
        public String toString() {
            return "Diesel";
        }
    }, PETROL {
        @Override
        public String toString() {
            return "Petrol";
        }
    }
}
