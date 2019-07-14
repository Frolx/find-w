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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vendor)) return false;

        Vendor vendor = (Vendor) o;

        if (name != null ? !name.equals(vendor.name) : vendor.name != null) return false;
        return vendorPrices != null ? vendorPrices.equals(vendor.vendorPrices) : vendor.vendorPrices == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (vendorPrices != null ? vendorPrices.hashCode() : 0);
        return result;
    }
}
