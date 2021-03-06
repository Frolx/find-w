package com.mizuho.dao;

import com.mizuho.datasoruce.Cache;
import com.mizuho.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PriceDAOImpl implements PriceDAO {

    @Autowired
    Cache cache;

    @Override
    public void addPrice(Price price) {
        cache.add(price);
    }

    @Override
    public List<Price> getAllPricesForTradeInstrument(String tradeInstrumentName) {
        return cache.getAllPrices(tradeInstrumentName);
    }
}