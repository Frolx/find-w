package com.mizuho.dao;

import com.mizuho.model.Price;
import com.mizuho.model.TradeInstrument;
import com.mizuho.model.Vendor;
import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class VendorDaoImpTest {

    @Autowired
    private VendorDAO vendorDAO;

    @Autowired PriceDAO priceDAO;

    @Test
    public void addVendor() {
        Vendor testVendor = new Vendor("John and Partners");
        vendorDAO.saveVendor(testVendor);
        assertEquals(testVendor, vendorDAO.getVendor(testVendor.getName()));

    }

    @Test
    public void getVendor() {
        Vendor testVendor = new Vendor("John and Partners");
        vendorDAO.saveVendor(testVendor);
        assertEquals(testVendor, vendorDAO.getVendor(testVendor.getName()));
    }

    @Test
    public void getAllVendorsTradeInstrumentPrices() {
        Vendor testVendor = new Vendor("John and Partners");
        TradeInstrument tradeInstrument = new TradeInstrument("Collateralized Loan Obligation");
        TradeInstrument tradeInstrument2 = new TradeInstrument("Forward Contract Definition");
        TradeInstrument tradeInstrument3 = new TradeInstrument("Credit Default Swap");

        priceDAO.addPrice(new Price(testVendor, tradeInstrument, new DateTime(), 320.99F));
        priceDAO.addPrice(new Price(testVendor, tradeInstrument2, new DateTime(), 32.99F));
        priceDAO.addPrice(new Price(testVendor, tradeInstrument3, new DateTime(), 520.99F));

        assertEquals(vendorDAO.getAllVendorsTradeInstrumentPrices(testVendor).size(), 3);
    }
}