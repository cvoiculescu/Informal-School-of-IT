package org.voiculescu.siit.temawk6;

/**
 * this class is to simulate basic operations on 3 numbers
 */
public class Calculator {
    private Integer a, b, c;

    /**
     * empty class initialisation. ALl values are null
     */
    public Calculator() {
    }

    /**
     * @param a first number
     * @param b second number
     * @param c third number
     */
    public Calculator(Integer a, Integer b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * @return the value of first number
     */
    public Integer getA() {
        return a;
    }

    /**
     * set the value of the first number
     *
     * @param a - set the parameter
     */
    public void setA(Integer a) {
        this.a = a;
    }

    /**
     * @return the value of second number
     */
    public Integer getB() {
        return b;
    }

    /**
     * set the value of the second number
     *
     * @param b - set the parameter b
     */
    public void setB(Integer b) {
        this.b = b;
    }

    /**
     * @return the value of third number
     */
    public Integer getC() {
        return c;
    }

    /**
     * set the value of the third number
     *
     * @param c - set the value of param c
     */
    public void setC(Integer c) {
        this.c = c;
    }

    /**
     * private method to identify if all params are null
     *
     * @return true if all are null
     */
    private boolean checkAllNull() {
        return (a == null && b == null && c == null);
    }

    /**
     * get the maximum value between the 3 numbers
     *
     * @return null if all params are null. If at least one is not null, the null values will be ignored
     */
    public Integer getMax() {
        if (checkAllNull()) {
            return null;
        }
        return Math.max(a != null ? a : Integer.MIN_VALUE,
                Math.max(b != null ? b : Integer.MIN_VALUE, c != null ? c : Integer.MIN_VALUE));
    }

    /**
     * get the minimum value between the 3 numbers
     *
     * @return null if all params are null. If at least one is not null, the null values will be ignored
     */
    public Integer getMin() {
        if (checkAllNull()) {
            return null;
        }
        return Math.min(a != null ? a : Integer.MAX_VALUE,
                Math.min(b != null ? b : Integer.MAX_VALUE, c != null ? c : Integer.MAX_VALUE));
    }

    /**
     * get the sum of the 3 numbers. any null values will be ignored
     *
     * @return null if all params are null. If at least one is not null, the null values will be ignored
     */
    public Integer getSum() {
        if (checkAllNull()) {
            return null;
        }
        return (a != null ? a : 0) + (b != null ? b : 0) + (c != null ? c : 0);
    }

    /**
     * get the average of the 3 numbers. Any null values will be ignored
     *
     * @return null if all params are null. If at least one is not null, the null values will be ignored
     */
    public Double getAvg() {
        if (checkAllNull()) {
            return null;
        }
        Integer sum = getSum();
        int count = (a != null ? 1 : 0) + (b != null ? 1 : 0) + (c != null ? 1 : 0);
        return (double) sum / (double) count;
    }

    /**
     * inform if all the numbers are positive. if at least a param is null, the result will be false
     *
     * @return true if all are positive
     */
    public boolean areAllPositive() {
        if (a == null || b == null || c == null) return false;
        return a >= 0 && b >= 0 && c >= 0;
    }

    /**
     * returns true if param a is even, else this will be false
     * if a is null, the number will be considered odd
     *
     * @return true if even, false if odd
     */
    public boolean isAEven() {
        if (a == null) return false;
        return a % 2 == 0;
    }
}
