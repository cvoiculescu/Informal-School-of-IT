package org.voiculescu.siit.temawk5.shop;

import java.util.Calendar;
import java.util.Date;

/**
 * this class is used to provide a meaning of doing the transaction between the Customer and the Shop
 */
public class PurchaseManager {

    /**
     * this method is used to execute the purchase transactions
     *
     * @param product  is the product to be purchased
     * @param customer is the customer which wants to buy the product
     */
    public static void processPurchase(Product product, Customer customer) {
        if (product.getQuantity() == 0) {
            System.out.println("Quantity out of stock");
            return;
        }
        if (product instanceof FoodProduct) {
            Date today = Calendar.getInstance().getTime();
            if ((((FoodProduct) product).getExpirationDate()).compareTo(today) <= 0) {
                System.out.println("The product " + product.getName() + " has expired");
                return;
            }
        }
        if (customer.getBalance() < product.getPrice()) {
            System.out.println("The customer " + customer.getName() + " does not have enough money");
        }
        AgeRestriction productAgeRestriction = product.getAgeRestriction();
        if (customer.getAge() < productAgeRestriction.getAge()) {
            System.out.println("Customer cannot buy \"" + product.getName() + "\" because of age restriction: " + productAgeRestriction);
            return;
        }
//        switch (productAgeRestriction) {
//            case Adult:
//                if (customer.getAge() < productAgeRestriction.getAge()) {
//                    System.out.println("Customer cannot buy item because of age restriction: "+productAgeRestriction);
//                    return;
//                }
//            case Teenager:
//                if (customer.getAge() < productAgeRestriction.getAge()) {
//                    System.out.println("Customer cannot buy item because of age restriction: "+productAgeRestriction);
//                    return;
//                }
//        }
        customer.setBalance(customer.getBalance() - product.getPrice());
        product.setQuantity(product.getQuantity() - 1);
    }
}
