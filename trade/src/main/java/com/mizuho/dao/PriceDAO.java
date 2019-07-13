package com.mizuho.dao;

import com.mizuho.model.Price;

import java.util.List;

public interface PriceDAO {
    void addPrice(Price price);

    Price getPrice(String tradeInstrumentName);

    List<Price> getAllPricesForTradeInstrument(String tradeInstrumentName);
}
