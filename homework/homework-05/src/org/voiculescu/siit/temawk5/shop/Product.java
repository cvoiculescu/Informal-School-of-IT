package org.voiculescu.siit.temawk5.shop;

/**
 * this class will implement the concept of a product based on name, price, quantity and age restriction
 */
public class Product implements Buyable {
    AgeRestriction ageRestriction;
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity, AgeRestriction ageRestriction) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.ageRestriction = ageRestriction;
    }

    /**
     * this method will return the age restriction for a product.
     * based on the age restriction the product can be bought by a customer or not
     *
     * @return returns the age restriction for the product
     */
    public AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    /**
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * @return the remaining quantity of a product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * this method is used to set the quantity of a product. this will be user when the product is purchased
     *
     * @param quantity will define a new quantity for the actual product
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    /**
     * @return the price of the current product
     */
    @Override
    public double getPrice() {
        return price;
    }
}
