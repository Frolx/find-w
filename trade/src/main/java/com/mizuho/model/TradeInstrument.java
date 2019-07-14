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
}
