package com.deloitte.im.service;

import com.deloitte.im.dto.ProductDetail;
import com.deloitte.im.enums.Coin;
import com.deloitte.im.enums.Flavor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Test class for Ice Cream Machine
 *
 * @author Chiranjit
 */
public class IceCreamMachineTest {

    private IceCreamMachine iceCreamMachine;

    @Before
    public void setUp() {
        iceCreamMachine = new IceCreamMachineImpl();
    }

    @Test
    public void testIceCreamWithExactPrice() {
        //select ice cream
        int price = iceCreamMachine.selectFlavorAndGetPrice(Flavor.CHOCOLATE);
        // chocolate ice cream price
        Assert.assertEquals(Flavor.CHOCOLATE.getPrice(), price);

        ProductDetail productDetail = iceCreamMachine.insertCoinAndGetProductDetails(Arrays.asList(Coin.CENT));
        //should get chocolate ice cream
        Assert.assertEquals(Flavor.CHOCOLATE, productDetail.getIceCream());
        //No refund
        Assert.assertEquals(0, productDetail.getRefund());
        //No change
        Assert.assertEquals(0, productDetail.getChangeAmount());
    }

    @Test
    public void testIceCreamWithLessPrice() {
        //select ice cream
        int price = iceCreamMachine.selectFlavorAndGetPrice(Flavor.STRAWBERRY);
        // STRAWBERRY ice cream price
        Assert.assertEquals(Flavor.STRAWBERRY.getPrice(), price);

        ProductDetail productDetail = iceCreamMachine.insertCoinAndGetProductDetails(Arrays.asList(Coin.DIME));
        //should get STRAWBERRY ice cream
        Assert.assertEquals(null, productDetail.getIceCream());
        //get refund
        Assert.assertEquals(10, productDetail.getRefund());
        //No change
        Assert.assertEquals(0, productDetail.getChangeAmount());
    }

    @Test
    public void testIceCreamWithMorePrice() {
        //select ice cream
        int price = iceCreamMachine.selectFlavorAndGetPrice(Flavor.VANILLA);
        // VANILLA ice cream price
        Assert.assertEquals(Flavor.VANILLA.getPrice(), price);

        ProductDetail productDetail = iceCreamMachine.insertCoinAndGetProductDetails(Arrays.asList(Coin.CENT));
        //should get vanilla ice cream
        Assert.assertEquals(Flavor.VANILLA, productDetail.getIceCream());
        //No refund
        Assert.assertEquals(0, productDetail.getRefund());
        //get change
        Assert.assertEquals(10, productDetail.getChangeAmount());
    }

    @After
    public void tearDown() {
        iceCreamMachine = null;
    }
}
