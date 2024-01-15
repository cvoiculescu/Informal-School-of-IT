package org.voiculescu.siit.temawk5.shop;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.voiculescu.siit.temawk5.shop.AgeRestriction.Adult;

public class ShopApp {
    public static void main(String[] args) {

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = "2020-01-30";
        Date myDate = null;
        try {
            myDate = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        FoodProduct cigars = new FoodProduct("420 blaze", 6.9, 1400,
                Adult, myDate);
        Customer pecata = new Customer("Pecata", 17, 30.0);
        PurchaseManager.processPurchase(cigars, pecata);
        Customer gopeto = new Customer("Gopeto", 18, 4.0);
        PurchaseManager.processPurchase(cigars, gopeto);

    }
}
