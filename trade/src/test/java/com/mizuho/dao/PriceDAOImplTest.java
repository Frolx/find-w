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

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PriceDAOImplTest {

    @Autowired
    PriceDAO priceDAO;

    @Test
    public void addPrice() {
        Vendor testVendor = new Vendor("CBS");
        TradeInstrument tradeInstrument = new TradeInstrument("Collateralized Loan Obligation");
        Price price = new Price(testVendor, tradeInstrument, new DateTime(), 320.99F);
        priceDAO.addPrice(price);
        List<Price> allPricesForTradeInstrument = priceDAO.getAllPricesForTradeInstrument(tradeInstrument.getName());
        assert(allPricesForTradeInstrument.contains(price));

    }

    @Test
    public void getAllPricesForTradeInstrument() {
        Vendor testVendor = new Vendor("CBS");
        Vendor testVendor2 = new Vendor("W2Q");
        TradeInstrument tradeInstrument = new TradeInstrument("Collateralized Loan Obligation");
        Price price = new Price(testVendor, tradeInstrument, new DateTime(), 320.99F);
        Price price2 = new Price(testVendor2, tradeInstrument, new DateTime(), 312.99F);
        priceDAO.addPrice(price);
        priceDAO.addPrice(price2);
        List<Price> allPricesForTradeInstrument = priceDAO.getAllPricesForTradeInstrument(tradeInstrument.getName());
        assertEquals(allPricesForTradeInstrument.size(), 2);

    }
}