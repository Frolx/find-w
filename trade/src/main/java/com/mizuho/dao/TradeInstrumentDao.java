package com.mizuho.dao;

import com.mizuho.model.TradeInstrument;

import java.util.List;

public interface TradeInstrumentDao {
    public List<TradeInstrument> getAllPricesForTradeInstrument(TradeInstrument tradeInstrument);

}
