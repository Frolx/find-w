package com.mizuho.dao;

import com.mizuho.model.Price;
import com.mizuho.model.Vendor;

import java.util.List;

public interface VendorDAO {

    List<Price> getAllVendorsTradeInstrumentPrices(Vendor vendor);

    void saveVendor(Vendor vendorName);

    Vendor getVendor(String vendorName);
}
