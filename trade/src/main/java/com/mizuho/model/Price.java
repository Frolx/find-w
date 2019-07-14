package com.mizuho.model;

import org.joda.time.DateTime;

import java.io.Serializable;

public class Price implements Serializable {
    private Vendor vendor;
    private TradeInstrument tradeInstrument;
    private DateTime publishedDate;
    private float price;

    public Price(Vendor vendor, TradeInstrument tradeInstrument, DateTime publishedDate, float price) {
        this.vendor = vendor;
        this.tradeInstrument = tradeInstrument;
        this.publishedDate = publishedDate;
        this.price = price;
    }


    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public TradeInstrument getTradeInstrument() {
        return tradeInstrument;
    }

    public void setTradeInstrument(TradeInstrument tradeInstrument) {
        this.tradeInstrument = tradeInstrument;
    }

    public DateTime getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(DateTime publishedDate) {
        this.publishedDate = publishedDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
