package com.mizuho.dao;

import com.mizuho.model.TradeInstrument;
import com.mizuho.model.Vendor;

import java.util.List;

public interface VendorDAO {

    List<TradeInstrument> getAllVendorsTradeInstrumentPrices(Vendor vendor);
}
