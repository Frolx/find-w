package com.mizuho.service;

import com.mizuho.dao.PriceDAO;
import com.mizuho.dao.TradeInstrumentDao;
import com.mizuho.dao.VendorDAO;
import com.mizuho.model.Price;
import com.mizuho.model.Vendor;
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

    public List<Vendor> getVendorIntrumentsPrice(String vendorName) {
        return null;
    }

    public List<Price> getInstrumentPrices(String instrumentName) {
        return null;
    }

    public void addVendor(String vendorName) {

        vendorDAO.addVendor(new Vendor(vendorName));
    }

    public void addPricedInstrumentToVendor(String vendorName, String tradeInstrumentName, float price){

    }

}
