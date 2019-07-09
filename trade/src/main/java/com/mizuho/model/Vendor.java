package com.mizuho.model;

import java.util.List;

public class Vendor {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TradeInstrument> getTradeInstruments() {
        return tradeInstruments;
    }

    public void setTradeInstruments(List<TradeInstrument> tradeInstruments) {
        this.tradeInstruments = tradeInstruments;
    }

    String name;
    List<TradeInstrument> tradeInstruments;

}
