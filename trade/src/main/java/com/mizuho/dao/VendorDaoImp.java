package com.mizuho.dao;

import com.mizuho.datasoruce.Cache;
import com.mizuho.model.Price;
import com.mizuho.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendorDaoImp implements VendorDAO {
    private Cache cache;

    @Autowired
    public VendorDaoImp(Cache cache){
        this.cache = cache;
    }

    @Override
    public void addVendor(Vendor vendor) {
        cache.add(vendor);
    }

    @Override
    public Vendor getVendor(String vendorName) {
        return cache.get(vendorName);
    }

    @Override
    public List<Price> getAllVendorsTradeInstrumentPrices(String vendor) {
        return cache.getVendorPrices(cache.get(vendor));
    }


}
