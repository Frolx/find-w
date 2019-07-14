package com.mizuho.service;

import com.mizuho.datasoruce.Cache;
import com.mizuho.model.Price;
import com.mizuho.model.TradeInstrument;
import com.mizuho.model.Vendor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeServiceTest {
    @Autowired
    Cache cache;

    @Autowired
    TradeService tradeService;

    @Test
    public void getVendorIntrumentsPrice() {
        Vendor vendor = new Vendor("KL Cons");
        TradeInstrument tradeInstrument = new TradeInstrument("Collateralized Loan Obligation");
        TradeInstrument tradeInstrument2 = new TradeInstrument("Forward Contract Definition");
        tradeService.addPricedInstrumentToVendor(vendor, tradeInstrument, 536F);
        tradeService.addPricedInstrumentToVendor(vendor, tradeInstrument2, 53F);

        List<Price> vendorIntrumentsPrice = tradeService.getVendorIntrumentsPrice(vendor.getName());
        boolean b = vendorIntrumentsPrice.stream().anyMatch(x -> x.getTradeInstrument().equals(tradeInstrument) || x.getTradeInstrument().equals(tradeInstrument2));
        assertEquals(2, vendorIntrumentsPrice.size());

        assertTrue(b);
    }

    @Test
    public void getInstrumentPrices() {
        String TRAD_EINSTRUMENT_NAME = "Collateralized Loan Obligation";
        Vendor vendor = new Vendor("KL Cons");
        Vendor vendor2 = new Vendor("MCS Cons");
        TradeInstrument tradeInstrument = new TradeInstrument(TRAD_EINSTRUMENT_NAME);
        TradeInstrument tradeInstrument2 = new TradeInstrument(TRAD_EINSTRUMENT_NAME);
        tradeService.addPricedInstrumentToVendor(vendor, tradeInstrument, 536F);
        tradeService.addPricedInstrumentToVendor(vendor2, tradeInstrument2, 53F);
        List<Price> instrumentPrices = tradeService.getInstrumentPrices(TRAD_EINSTRUMENT_NAME);

        boolean thereIsTwoPricesForInstrument = instrumentPrices.stream().anyMatch(x -> x.getPrice() == 536F || x.getPrice() == 53F);
        assertTrue(thereIsTwoPricesForInstrument);
    }

    @Test
    public void addVendor() {
        String vendorName = "EQ Trade";
        tradeService.addVendor(vendorName);
        assertEquals(tradeService.getVendor(vendorName).getName(), vendorName);
    }

    @Test
    public void addPricedInstrumentToVendor() {
        String TRAD_EINSTRUMENT_NAME = "Collateralized Loan Obligation";
        Vendor vendor = new Vendor("KL Cons");
        TradeInstrument tradeInstrument = new TradeInstrument(TRAD_EINSTRUMENT_NAME);
        tradeService.addPricedInstrumentToVendor(vendor, tradeInstrument, 536F);
        List<Price> vendorIntrumentsPrice = tradeService.getVendorIntrumentsPrice(vendor.getName());
        assertEquals(1, vendorIntrumentsPrice.size());

    }
}