package com.deloitte.im.dto;

import com.deloitte.im.enums.Flavor;

/**
 * Dto class for Product details
 * response for Ice Cream Machine
 * @author Chiranjit
 */
public class ProductDetail {
    private Flavor iceCream;
    private int changeAmount;
    private int refund;

    public Flavor getIceCream() {
        return iceCream;
    }

    public void setIceCream(Flavor iceCream) {
        this.iceCream = iceCream;
    }

    public int getChangeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(int changeAmount) {
        this.changeAmount = changeAmount;
    }

    public int getRefund() {
        return refund;
    }

    public void setRefund(int refund) {
        this.refund = refund;
    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "iceCream=" + iceCream +
                ", changeAmount=" + changeAmount +
                ", refund=" + refund +
                '}';
    }
}
