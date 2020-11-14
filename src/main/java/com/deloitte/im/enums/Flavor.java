package com.deloitte.im.enums;

/**
 * enum for Flavor
 *
 * @author Chiranjit
 */
public enum Flavor {

    CHOCOLATE("Chocolate", 100), VANILLA("Vanilla", 90), STRAWBERRY("Strawberry", 110);

    private String name;
    private int price;

    /**
     * @param name flavor name
     * @param price flavor price
     */
    Flavor(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * @return flavor name
     */
    public String getName() {
        return name;
    }

    /**
     * @return  flavor price
     */
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Flavor{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

