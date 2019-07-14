package com.mizuho.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Vendor implements Serializable {
    private String name;
    private List<Price> vendorPrices;

    public Vendor(String name) {
        this.name = name;
        this.vendorPrices = new ArrayList<>();
    }

    public Vendor(String name, List<Price> vendorPrices) {
        this.name = name;
        this.vendorPrices = vendorPrices;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Price> getVendorPrices() {
        return vendorPrices;
    }

    public void setVendorPrices(List<Price> vendorPrices) {
        this.vendorPrices = vendorPrices;
    }

}
