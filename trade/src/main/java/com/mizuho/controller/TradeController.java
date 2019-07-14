package com.mizuho.controller;

import com.mizuho.model.Price;
import com.mizuho.model.TradeInstrument;
import com.mizuho.model.Vendor;
import com.mizuho.service.TradeService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(path = "/demo")
public class TradeController {

    @Autowired
    TradeService tradeService;

    @RequestMapping(value = "/instrument/price/getAll", method = RequestMethod.GET,  produces = "application/json")
    public @ResponseBody List<Price> getTradeInstrumentPrices(@RequestParam(name = "instrumentName", required = true)String instrumentName) {
        return tradeService.getInstrumentPrices(instrumentName);
    }

    @RequestMapping(value = "/vendor/prices/get", method = RequestMethod.GET,  produces = "application/json")
    public @ResponseBody List<Price> getVendorPrices(@RequestParam(name = "vendorName", required = true)String vendorName) {

        return tradeService.getVendorIntrumentsPrice(vendorName);
    }

    @RequestMapping(value = "/vendor/add/{vendorName}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String addVendor(@PathVariable String vendorName) {
        tradeService.addVendor(vendorName);
        return "Vendor " + vendorName + " added.";
    }

    @RequestMapping(value = "/vendor/instrument/add/{vendor}/{tradeInstrument}/{price}", method = RequestMethod.POST,  produces = "application/json")
    @ResponseBody
    public String addInstrumentToVendor(@PathVariable Vendor vendor, @PathVariable TradeInstrument tradeInstrument, @PathVariable float price) {

        tradeService.addPricedInstrumentToVendor(vendor, tradeInstrument, price);
        new Price(vendor, tradeInstrument, new DateTime(), price);
        return "home";
    }
}
