package org.voiculescu.siit.temawk5.shop;

/**
 * this class is used to define appliances electronics, which have a standard guarantee of 6 months
 */
public class Appliance extends ElectronicsProduct {
    public Appliance(String name, double price, int quantity, AgeRestriction ageRestriction) {
        super(name, price, quantity, ageRestriction, 6);
    }

    /**
     * if the quantity of this product is less than 50 pcs. then the price will be increased by 5%
     *
     * @return return the price of the ElectronicsProduct based on the remaining quantity
     */
    @Override
    public double getPrice() {
        if (this.getQuantity() < 50) return super.getPrice() * 1.05;
        return super.getPrice();
    }

}
