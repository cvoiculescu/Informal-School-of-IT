package org.voiculescu.siit.temawk5.shop;

/**
 * this class is defining an Electronic Product with a guarantee period of 24 months
 */
public class Computer extends ElectronicsProduct {
    public Computer(String name, double price, int quantity, AgeRestriction ageRestriction, int guaranteePeriod) {
        super(name, price, quantity, ageRestriction, 24);
    }

    /**
     * if the quantity is more than 1000 products then a 5% discount will be applied to the regular price
     *
     * @return the price based on the remaining quantity
     */
    @Override
    public double getPrice() {
        if (this.getQuantity() > 1000) return super.getPrice() * 0.95;
        return super.getPrice();
    }
}
