package com.mizuho.service;

import com.mizuho.dao.PriceDAO;
import com.mizuho.dao.TradeInstrumentDao;
import com.mizuho.dao.VendorDAO;
import com.mizuho.model.Price;
import com.mizuho.model.TradeInstrument;
import com.mizuho.model.Vendor;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.transform.OutputKeys;
import java.util.List;

@Component
public class TradeService {

    private PriceDAO priceDAO;
    private TradeInstrumentDao tradeInstrumentDao;
    private VendorDAO vendorDAO;

    @Autowired
    public TradeService(PriceDAO priceDAO, TradeInstrumentDao tradeInstrumentDao, VendorDAO vendorDAO){
        this.priceDAO = priceDAO;
        this.tradeInstrumentDao = tradeInstrumentDao;
        this.vendorDAO = vendorDAO;
    }

    public List<Price> getVendorIntrumentsPrice(String vendorName) {

        return vendorDAO.getAllVendorsTradeInstrumentPrices(vendorDAO.getVendor(vendorName));
    }

    public List<Price> getInstrumentPrices(String instrumentName) {
        return priceDAO.getAllPricesForTradeInstrument(instrumentName);

    }

    public void addVendor(String vendorName) {

        vendorDAO.addVendor(new Vendor(vendorName));
    }

    public void addPricedInstrumentToVendor(Vendor vendorName, TradeInstrument tradeInstrument, float price){

        priceDAO.addPrice(new Price(vendorName, tradeInstrument, new DateTime(), price));
    }

}
