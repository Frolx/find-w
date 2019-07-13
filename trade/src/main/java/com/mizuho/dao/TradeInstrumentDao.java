package com.mizuho.dao;

import com.mizuho.model.TradeInstrument;

import java.util.List;

public interface TradeInstrumentDao {
    void addInstrument(TradeInstrument tradeInstrument);
    void getInstrument(String name);

}
