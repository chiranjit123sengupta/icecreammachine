package com.deloitte.im.service;

import com.deloitte.im.dto.ProductDetail;
import com.deloitte.im.enums.Coin;
import com.deloitte.im.enums.Flavor;
import com.deloitte.im.util.IceCreamStore;

import java.util.List;

/**
 * Service implementation for Ice Cream Machine
 * @author Chiranjit
 */
public class IceCreamMachineImpl implements IceCreamMachine {

    private Flavor selectedFlavor;
    private IceCreamStore iceCreamStore = IceCreamStore.getIceCreamStore();

    /**
     * @param flavor type of flavor
     * @return
     */
    public int selectFlavorAndGetPrice(Flavor flavor) {

        if(iceCreamStore.hasFlavor(flavor)){
            selectedFlavor = flavor;

        }
        return selectedFlavor.getPrice();
    }

    /**
     * @param coins list of coins
     */
    public ProductDetail insertCoinAndGetProductDetails(List<Coin> coins) {
        ProductDetail productDetail = new ProductDetail();
        int refund =0;
        int totalCoinValue = coins.stream().mapToInt(c->c.getCoinValue()).sum();
        int changeAmount = totalCoinValue - selectedFlavor.getPrice();
        if(changeAmount < 0){
            refund = totalCoinValue;
            changeAmount = 0;
            productDetail.setChangeAmount(changeAmount);
            productDetail.setRefund(refund);
            return productDetail;
        }
        productDetail.setIceCream(selectedFlavor);
        productDetail.setChangeAmount(changeAmount);
        productDetail.setRefund(refund);
        iceCreamStore.deduct(selectedFlavor);
        selectedFlavor = null;
        return productDetail;
    }
}
