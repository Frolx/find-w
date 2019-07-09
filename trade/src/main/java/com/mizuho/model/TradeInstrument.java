package com.mizuho.model;


import org.joda.time.DateTime;

public class TradeInstrument {
    private String name;
    private float price;
    private DateTime publishetDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public DateTime getPublishetDate() {
        return publishetDate;
    }

    public void setPublishetDate(DateTime publishetDate) {
        this.publishetDate = publishetDate;
    }

}
