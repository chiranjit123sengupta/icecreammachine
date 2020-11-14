package com.deloitte.im.starter;

import com.deloitte.im.dto.ProductDetail;
import com.deloitte.im.enums.Coin;
import com.deloitte.im.enums.Flavor;
import com.deloitte.im.service.IceCreamMachine;
import com.deloitte.im.service.IceCreamMachineImpl;

import java.util.Arrays;

/**
 * Main class to start the Ice Cream Machine
 * @author Chiranjit
 */
public class IceCreamMachineStarter {

    public static void main(String[] args) {

        IceCreamMachine iceCreamMachine = new IceCreamMachineImpl();
        int iceCreamPrice = iceCreamMachine.selectFlavorAndGetPrice(Flavor.CHOCOLATE);
        System.out.println("Ice Cream Price : "+iceCreamPrice);
        ProductDetail productDetail = iceCreamMachine.insertCoinAndGetProductDetails(Arrays.asList(Coin.DIME,Coin.NICKLE));
        System.out.println(productDetail);
    }
}
