package org.voiculescu.siit.temawk5.shop;

/**
 * this interface ensures that a product will have a price
 */
public interface Buyable {
    /**
     * this method will return the price for a product
     *
     * @return returns the price of the Buyable item
     */
    double getPrice();
}
