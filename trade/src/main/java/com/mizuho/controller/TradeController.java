package com.mizuho.controller;

import com.mizuho.model.Price;
import com.mizuho.service.TradeService;
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

    @RequestMapping(value = "/instrument/price/getAll", method = RequestMethod.GET)
    public String getTradeInstrumentPrices(Locale locale, Model model) {

        return "home";
    }

    @RequestMapping(value = "/vendor/prices/get", method = RequestMethod.GET)
    public String getVendorPrices(Locale locale, Model model) {

        return "home";
    }

    @RequestMapping(value = "/vendor/add/{vendorName}", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String addVendor(@PathVariable String vendorName) {
        tradeService.addVendor(vendorName);
        return "Vendor " + vendorName + " added.";
    }

    @RequestMapping(value = "/vendor/instrument/add", method = RequestMethod.POST,  produces = "application/json")
    public String addInstrumentToVendor(@RequestBody List<Price> cars) {

        return "home";
    }
}
