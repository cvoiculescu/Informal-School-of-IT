package org.voiculescu.siit.temawk5.shop;

import java.util.Date;

/**
 * the FoodProduct is used to define products with expiration date
 */
public class FoodProduct extends Product implements Expirable {
    private Date expirationDate;

    public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestriction, Date expirationDate) {
        super(name, price, quantity, ageRestriction);
        this.expirationDate = expirationDate;
    }

    /**
     * @return the date when the product will expire
     */
    @Override
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     * when the product has less than 15 days till the expiration date, there will be a 30% discount to the regular price
     *
     * @return the price of the product
     */
    @Override
    public double getPrice() {
        int days = (int) ((expirationDate.getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24));
        if (days <= 15) {
            return super.getPrice() * 0.7;
        }
        return super.getPrice();
    }
}
