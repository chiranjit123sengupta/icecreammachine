package com.deloitte.im.enums;

/**
 * Dto enum for Coin
 *
 * @author Chiranjit
 */
public enum Coin {

    NICKLE(50), DIME(10), QUARTER(25), CENT(100);

    private int coinValue;

    Coin(int coinValue) {
        this.coinValue = coinValue;
    }

    public int getCoinValue() {
        return coinValue;
    }
}
