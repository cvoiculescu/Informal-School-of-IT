package org.voiculescu.siit.temawk5.shop;

/**
 * this class will define the customer based on name, age and the amount of money he got
 */
public class Customer {
    private String name;
    private int age;
    private double balance;

    public Customer(String name, int age, double balance) {
        this.name = name;
        this.age = age;
        this.balance = balance;
    }

    /**
     * this method will give the name of the Customer
     *
     * @return the name of the Customer
     */
    public String getName() {
        return name;
    }

    /**
     * this method provides the age of the current customer
     *
     * @return the age of the customer
     */
    public int getAge() {
        return age;
    }

    /**
     * this method will return the amount of money the current customer have
     *
     * @return the remaining money the customer have
     */
    public double getBalance() {
        return balance;
    }

    /**
     * this method is used when a purchase is made in order to decrease the balance of the customer
     *
     * @param balance set the new amount of money the Customer will have
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
