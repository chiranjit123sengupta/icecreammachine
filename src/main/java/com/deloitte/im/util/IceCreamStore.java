package com.deloitte.im.util;

import com.deloitte.im.enums.Flavor;

import java.util.HashMap;
import java.util.Map;

/**
 * Util to maintain Ice Cream store
 * @author Chiranjit
 */
public class IceCreamStore {

    private Map<Flavor, Integer> iceCreamStoreMap = new HashMap<Flavor, Integer>();
    private static IceCreamStore iceCreamStore;

    private IceCreamStore() {
        iceCreamStoreMap.put(Flavor.CHOCOLATE,10);
        iceCreamStoreMap.put(Flavor.STRAWBERRY,10);
        iceCreamStoreMap.put(Flavor.VANILLA,10);
    }

    /**
     * To return singleton IceCreamStore
     * @return
     */
    public static IceCreamStore getIceCreamStore(){
        if(iceCreamStore == null){
            iceCreamStore = new IceCreamStore();
        }
        return iceCreamStore;
    }

    /**
     * @param flavor
     * @return
     */
    public int getQuantity(Flavor flavor) {
        Integer value = iceCreamStoreMap.get(flavor);
        return value == null ? 0 : value;
    }

    /**
     * @param flavor
     * deduct from store
     */
    public void deduct(Flavor flavor) {
        if (hasFlavor(flavor)) {
            int count = iceCreamStoreMap.get(flavor);
            iceCreamStoreMap.put(flavor, count - 1);
        }
    }

    /**
     * @param flavor
     * check ice cream stock
     * @return
     */
    public boolean hasFlavor(Flavor flavor) {
        return getQuantity(flavor) > 0;
    }

}

