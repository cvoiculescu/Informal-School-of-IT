package org.voiculescu.siit.temawk5.shop;

/**
 * this class is used to define electronics products which have a guarantee period
 */
public class ElectronicsProduct extends Product {
    private int guaranteePeriod;

    public ElectronicsProduct(String name, double price, int quantity, AgeRestriction ageRestriction, int guaranteePeriod) {
        super(name, price, quantity, ageRestriction);
        this.guaranteePeriod = guaranteePeriod;
    }

    /**
     * returns the standard guarantee period
     *
     * @return returns the guarantee period of the ElectronicsProduct
     */
    public int getGuaranteePeriod() {
        return this.guaranteePeriod;
    }
}
