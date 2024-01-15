package org.voiculescu.siit.temawk5.shop;

import java.util.Date;

/**
 * this interface ensure that a product has an expiration date.
 */
public interface Expirable {

    /**
     * this method will return the expiration date for a product
     *
     * @return - returns the expiration date of the "Expirable"  Object
     */
    Date getExpirationDate();
}
