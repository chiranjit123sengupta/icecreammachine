package com.deloitte.im.service;

import com.deloitte.im.dto.ProductDetail;
import com.deloitte.im.enums.Coin;
import com.deloitte.im.enums.Flavor;

import java.util.List;

/**
 * Service interface for Ice Cream Machine
 * @author Chiranjit
 */
public interface IceCreamMachine {

    /**
     * @param flavor type of flavor
     * @return
     */
    public int selectFlavorAndGetPrice(Flavor flavor);

    /**
     * @param coin list of coins
     */
    public ProductDetail insertCoinAndGetProductDetails(List<Coin> coin);
}
