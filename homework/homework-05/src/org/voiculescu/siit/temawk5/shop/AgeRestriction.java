package org.voiculescu.siit.temawk5.shop;

/**
 * enum user for defining age restriction for products
 */
public enum AgeRestriction {
    None(0) {
        @Override
        public String toString() {
            return "None";
        }
    }, Teenager(12) {
        @Override
        public String toString() {
            return "Teenager";
        }
    }, Adult(18) {
        @Override
        public String toString() {
            return "Adult";
        }
    };

    int age;

    AgeRestriction(int age) {
        this.age = age;
    }

    int getAge() {
        return this.age;
    }
}
