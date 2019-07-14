package com.mizuho.model;


import java.io.Serializable;

public class TradeInstrument implements Serializable {
    private String name;

    public TradeInstrument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TradeInstrument)) return false;

        TradeInstrument that = (TradeInstrument) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
