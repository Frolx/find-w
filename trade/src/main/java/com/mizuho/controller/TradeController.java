package com.mizuho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping(path = "/demo")
public class TradeController {

    @RequestMapping(value = "/getVendorPrices", method = RequestMethod.GET)
    public String getVendorPrices(Locale locale, Model model) {

        return "home";
    }

    @RequestMapping(value = "/getTradeInstrumentPrices", method = RequestMethod.GET)
    public String getTradeInstrumentPrices(Locale locale, Model model) {

        return "home";
    }
}
