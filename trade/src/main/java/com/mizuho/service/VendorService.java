package com.mizuho.service;

import com.mizuho.dao.PriceDAO;
import com.mizuho.dao.VendorDAO;
import com.mizuho.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;

public class VendorService {
    private VendorDAO vendorDAO;
    private PriceDAO priceDAO;
    @Autowired
    public VendorService(VendorDAO vendorDAO, PriceDAO priceDAO) {
        this.vendorDAO = vendorDAO;
        this.priceDAO = priceDAO;
    }

    public void addVendor(String vendorName) {

    }

    public Vendor getVendor(String vendorName) {
        return null;

    }

    public void addInstrumentToVendor(Vendor vendor) {

    }

}
