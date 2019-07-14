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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;

        Price price1 = (Price) o;

        if (Float.compare(price1.price, price) != 0) return false;
        if (vendor != null ? !vendor.equals(price1.vendor) : price1.vendor != null) return false;
        if (tradeInstrument != null ? !tradeInstrument.equals(price1.tradeInstrument) : price1.tradeInstrument != null)
            return false;
        return publishedDate != null ? publishedDate.equals(price1.publishedDate) : price1.publishedDate == null;
    }

    @Override
    public int hashCode() {
        int result = vendor != null ? vendor.hashCode() : 0;
        result = 31 * result + (tradeInstrument != null ? tradeInstrument.hashCode() : 0);
        result = 31 * result + (publishedDate != null ? publishedDate.hashCode() : 0);
        result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
        return result;
    }
}
